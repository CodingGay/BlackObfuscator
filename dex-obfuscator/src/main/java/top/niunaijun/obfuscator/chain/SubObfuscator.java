package top.niunaijun.obfuscator.chain;

import com.googlecode.dex2jar.ir.IrMethod;
import com.googlecode.dex2jar.ir.expr.Constant;
import com.googlecode.dex2jar.ir.expr.Exprs;
import com.googlecode.dex2jar.ir.expr.Local;
import com.googlecode.dex2jar.ir.expr.Value;
import com.googlecode.dex2jar.ir.stmt.Stmt;
import com.googlecode.dex2jar.ir.stmt.Stmts;
import top.niunaijun.obfuscator.ObfuscatorConfiguration;
import top.niunaijun.obfuscator.RebuildIfResult;
import top.niunaijun.obfuscator.chain.base.BaseObfuscatorChain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SubObfuscator extends BaseObfuscatorChain {

    public SubObfuscator(ObfuscatorConfiguration obfuscatorConfiguration) {
        super(obfuscatorConfiguration);
    }

    @Override
    public boolean canHandle(IrMethod ir, Stmt stmt) {
        return stmt.st == Stmt.ST.ASSIGN ||
                stmt.st == Stmt.ST.VOID_INVOKE;
    }

    @Override
    public RebuildIfResult reBuild0(IrMethod ir, Stmt stmt, List<Stmt> origStmts) {
        List<Stmt> newStmts = new ArrayList<>();
        RebuildIfResult rebuildIfResult = new RebuildIfResult(newStmts);
        switch (stmt.st) {
            case ASSIGN:
                reBuildAssign(ir, stmt, origStmts, newStmts);
                break;
            case VOID_INVOKE:
                reBuildVoidInvoke(ir, stmt, origStmts, newStmts);
                break;
            default:
                newStmts.add(stmt);
                break;
        }
        return rebuildIfResult;
    }

    @Override
    public void reBuildEnd(IrMethod ir, List<Stmt> newStmts, List<Stmt> origStmts) {

    }

    private void reBuildAssign(IrMethod ir, Stmt stmt, List<Stmt> origStmts, List<Stmt> newStmts) {
        Stmt.E2Stmt e2 = (Stmt.E2Stmt) stmt;
        Value v1 = e2.op1;
        Value v2 = e2.op2;
        switch (v1.vt) {
            case LOCAL:
                if (v1.valueType.charAt(0) == 'I') {
                    if (v2.vt == Value.VT.ADD) {
                        if (v2.getOp2().vt == Value.VT.CONSTANT) {
                            // a=b+c	a=b-(-c)
                            int increment = (Integer) ((Constant) v2.getOp2()).value;
                            v2.vt = Value.VT.SUB;
                            v2.setOp2(Exprs.nInt(-increment));
                        }
                    } else if (v2.vt == Value.VT.SUB) {
                        if (v2.getOp2().vt == Value.VT.CONSTANT) {
                            // a=b-c	a=b+(-c)
                            int increment = (Integer) ((Constant) v2.getOp2()).value;
                            v2.vt = Value.VT.ADD;
                            v2.setOp2(Exprs.nInt(-increment));
                        }
                    } else if (v2.vt == Value.VT.XOR) {
                        // a=a^b	(a ^ r) ^ (b ^ r)

                        // seed
                        Local local = newLocal("xor", "I");
                        newStmts.add(Stmts.nAssign(local, Exprs.nInt(new Random().nextInt(1000))));

                        Local left = newLocal("xor_left", "I");
                        newStmts.add(Stmts.nAssign(left, Exprs.nXor(v2.getOp1(), local, "I")));
                        v2.setOp1(left);

                        Local right = newLocal("xor_right", "I");
                        newStmts.add(Stmts.nAssign(right, Exprs.nXor(v2.getOp2(), local, "I")));
                        v2.setOp2(right);
                    }
                }
                break;
        }
        newStmts.add(stmt);
    }

    private void reBuildVoidInvoke(IrMethod ir, Stmt stmt, List<Stmt> origStmts, List<Stmt> newStmts) {
        Stmt.E1Stmt e1 = (Stmt.E1Stmt) stmt;
        newStmts.add(stmt);
    }
}
