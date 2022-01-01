package top.niunaijun.obfuscator.chain;

import com.googlecode.dex2jar.ir.IrMethod;
import com.googlecode.dex2jar.ir.Trap;
import com.googlecode.dex2jar.ir.expr.Exprs;
import com.googlecode.dex2jar.ir.expr.InvokeExpr;
import com.googlecode.dex2jar.ir.expr.Local;
import com.googlecode.dex2jar.ir.expr.Value;
import com.googlecode.dex2jar.ir.stmt.*;
import top.niunaijun.obfuscator.LBlock;
import top.niunaijun.obfuscator.ObfuscatorConfiguration;
import top.niunaijun.obfuscator.RebuildIfResult;
import top.niunaijun.obfuscator.chain.base.BaseObfuscatorChain;

import java.util.*;

import static com.googlecode.dex2jar.ir.stmt.Stmt.ST.IF;
import static com.googlecode.dex2jar.ir.stmt.Stmt.ST.LABEL;

public class IfObfuscator extends BaseObfuscatorChain {

    private static final int MAPPING_INDEX = 0;
    private static final int MAPPING_GOTO = 1;
    private static final int MAPPING_ELSE = 2;
    private static final int MAPPING_ENTER = 3;
    private static final int MAPPING_NEXT = 4;
    private static final int MAPPING_FAKE = 5;

    public IfObfuscator(ObfuscatorConfiguration obfuscatorConfiguration) {
        super(obfuscatorConfiguration);
    }

    @Override
    public boolean canHandle(IrMethod ir, Stmt stmt) {
        return stmt.st == IF;
    }

    @Override
    public RebuildIfResult reBuild0(IrMethod ir, Stmt stmt, List<Stmt> origStmts) {
        List<Stmt> newStmts = new ArrayList<>();
        IfStmt ifStmt = (IfStmt) stmt;
        // if goto
        LBlock targetBlock = getIfTargetStmts(ifStmt);

        LBlock elseBlock = generateLBlock();

        Map<Integer, String> mapping = generateObfLocalMapping(depth);

        Local obfIndexFinal = newLocal("obf_index_final", "I");
        Local obfIndex = newLocal("obf_index", "I");
        Local obfStrHash = newLocal("obf_hash", "I");
        Local obfStr = newLocal("obf_str", "Ljava/lang/String;");

        LBlock startBlock = generateLBlock();
        int obfIndexI = mapping.get(MAPPING_INDEX).hashCode();
        newStmts.add(startBlock.getLabelStmt());

        // int obf_index_final = 1;
        newStmts.add(Stmts.nAssign(obfIndexFinal, Exprs.nInt(obfIndexI)));

        newStmts.add(Stmts.nAssign(obfStr, Exprs.nString(mapping.get(MAPPING_ENTER))));

        LabelStmt whileBegin = createWhile(newStmts);

        // 创建 ^ 操作
        newStmts.add(Stmts.nAssign(obfStrHash, hashInvoke(obfStr)));
        newStmts.add(Stmts.nAssign(obfIndex, Exprs.nXor(obfIndexFinal, obfStrHash, "I")));

        LBlock fake = generateLBlock();
        fake.getStmts().add(Stmts.nAssign(obfIndex, obfIndex));
        fake.getStmts().add(Stmts.nGoto(whileBegin));

        // goto的跳板，由于没办法直接回到whileBegin并且计算obfIndex，所以需要此跳板来来操作.
        // 跳板将跳转回原goto
        LBlock gotoJumpBlock = generateLBlock();
        gotoJumpBlock.getStmts().add(Stmts.nAssign(obfStr, Exprs.nString(mapping.get(MAPPING_GOTO))));
        gotoJumpBlock.getStmts().add(Stmts.nGoto(whileBegin));

        LBlock enterBlock = generateLBlock();
        ifStmt.target = gotoJumpBlock.getLabelStmt();
        enterBlock.getStmts().add(ifStmt);
        enterBlock.getStmts().add(Stmts.nAssign(obfStr, Exprs.nString(mapping.get(MAPPING_ELSE))));
        enterBlock.getStmts().add(Stmts.nGoto(whileBegin));

        // else块需要重跳回whileBegin，进行最后跳跃到nextStep
        elseBlock.getStmts().add(Stmts.nAssign(obfStr, Exprs.nString(mapping.get(MAPPING_NEXT))));
        elseBlock.getStmts().add(Stmts.nGoto(whileBegin));

        LBlock nextBlock = generateLBlock();

        LBlock defaultTarget = generateLBlock();

        Map<Integer, LabelStmt> switchBlock = new LinkedHashMap<>();
        Map<Integer, LabelStmt> newSwitchBlock = new LinkedHashMap<>();
        switchBlock.put(mapping.get(MAPPING_GOTO).hashCode() ^ obfIndexI, targetBlock.getLabelStmt());
        switchBlock.put(mapping.get(MAPPING_ELSE).hashCode() ^ obfIndexI, elseBlock.getLabelStmt());
        switchBlock.put(mapping.get(MAPPING_ENTER).hashCode() ^ obfIndexI, enterBlock.getLabelStmt());
        switchBlock.put(mapping.get(MAPPING_NEXT).hashCode() ^ obfIndexI, nextBlock.getLabelStmt());
        switchBlock.put(mapping.get(MAPPING_FAKE).hashCode() ^ obfIndexI, fake.getLabelStmt());
        List<Integer> sortList = new ArrayList<>(switchBlock.keySet());
        Collections.shuffle(sortList);
        for (Integer integer : sortList) {
            newSwitchBlock.put(integer, switchBlock.get(integer));
        }


        // switch(obfIndex)
        LookupSwitchStmt lookupSwitchStmt = Stmts.nLookupSwitch(obfIndex,
                newSwitchBlock.keySet().stream().mapToInt(integer -> integer).toArray(),
                newSwitchBlock.values().toArray(new LabelStmt[]{}),
                defaultTarget.getLabelStmt());

        newStmts.add(lookupSwitchStmt);
        // add default, do noting
        newStmts.add(defaultTarget.getLabelStmt());
        newStmts.addAll(defaultTarget.getStmts());
        // add fake
        newStmts.add(fake.getLabelStmt());
        newStmts.addAll(fake.getStmts());
        // add goto jump
        newStmts.add(gotoJumpBlock.getLabelStmt());
        newStmts.addAll(gotoJumpBlock.getStmts());
        // add enter
        newStmts.add(enterBlock.getLabelStmt());
        newStmts.addAll(enterBlock.getStmts());
        // add else
        newStmts.add(elseBlock.getLabelStmt());
        newStmts.addAll(elseBlock.getStmts());
        // add next
        newStmts.add(nextBlock.getLabelStmt());
        newStmts.addAll(nextBlock.getStmts());

        LabelStmt ifStmtLabel = findIfStmtLabel(ifStmt, origStmts);
        if (ifStmtLabel != null) {
            for (Trap trap : ir.traps) {
                if (trap.end == ifStmtLabel) {
                    trap.end = elseBlock.getLabelStmt();
                }
            }
        }
        return new RebuildIfResult(newStmts);
    }

    @Override
    public void reBuildEnd(IrMethod ir, List<Stmt> newStmts, List<Stmt> origStmts) {

    }


    private LBlock generateLBlock() {
        return new LBlock();
    }

    private InvokeExpr hashInvoke(Local strLocal) {
        return Exprs.nInvokeVirtual(new Value[]{strLocal}, "Ljava/lang/String;","hashCode", new String[]{}, "I");
    }

    private Map<Integer, String> generateObfLocalMapping(int depth) {
        Map<Integer, String> mapping = new HashMap<>();
        mapping.put(MAPPING_INDEX, randomString(depth));
        mapping.put(MAPPING_GOTO, randomString(depth));
        mapping.put(MAPPING_ELSE, randomString(depth));
        mapping.put(MAPPING_ENTER, randomString(depth));
        mapping.put(MAPPING_NEXT, randomString(depth));
        mapping.put(MAPPING_FAKE, randomString(depth));

        Set<String> set = new HashSet<>();
        for (String value : mapping.values()) {
            if (set.contains(value)) {
                return generateObfLocalMapping(depth);
            } else {
                set.add(value);
            }
        }
        return mapping;
    }

    private LabelStmt createWhile(List<Stmt> newStmts) {
        LBlock block = new LBlock();
        newStmts.add(block.getLabelStmt());
        return block.getLabelStmt();
    }

    private LBlock getIfTargetStmts(IfStmt ifStmt) {
        LBlock block = new LBlock();
        block.setLabelStmt(ifStmt.target);
        return block;
    }

    private LabelStmt findIfStmtLabel(IfStmt ifStmt, List<Stmt> orig) {
        boolean found = false;
        for (int i = orig.size() - 1; i >= 0; i--) {
            Stmt stmt = orig.get(i);
            if (stmt == ifStmt) {
                found = true;
            } else if (found && stmt.st == LABEL) {
                return (LabelStmt) stmt;
            }
        }
        return null;
    }


}
