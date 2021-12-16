package top.niunaijun.obfuscator;

import com.googlecode.dex2jar.ir.IrMethod;
import com.googlecode.dex2jar.ir.Trap;
import com.googlecode.dex2jar.ir.expr.Exprs;
import com.googlecode.dex2jar.ir.expr.Local;
import com.googlecode.dex2jar.ir.stmt.*;

import java.util.*;

import static com.googlecode.dex2jar.ir.stmt.Stmt.ST.*;

public class IRObfuscator {
	private static final int MAPPING_INDEX = 0;
	private static final int MAPPING_GOTO = 1;
	private static final int MAPPING_ELSE = 2;
	private static final int MAPPING_ENTER = 3;
	private static final int MAPPING_NEXT = 4;
	private static final int MAPPING_FAKE = 5;

	private static IRObfuscator obfuscator;
	private final ObfuscatorConfiguration configuration;

	public static IRObfuscator get(ObfuscatorConfiguration obf) {
		if (obfuscator == null) {
			synchronized (IRObfuscator.class) {
				if (obfuscator == null) {
					obfuscator = new IRObfuscator(obf);
				}
			}
		}
		return obfuscator;
	}

	public IRObfuscator(ObfuscatorConfiguration configuration) {
		this.configuration = configuration;
	}

	public void reBuildInstructions(IrMethod ir) {
		if (configuration == null)
			return;
		if (!configuration.accept(ir.owner, ir.name)) {
			return;
		}
		for (int i = 0; i < configuration.getObfDepth(); i++) {
			List<Stmt> origStmts = new ArrayList<>();
			List<Stmt> newStmts = new ArrayList<>();
			for (Stmt value : ir.stmts) {
				origStmts.add(value);
			}

			RebuildIfResult rebuildIfResult;
			for (Stmt stmt : ir.stmts) {
				switch (stmt.st) {
					case IF:
						rebuildIfResult = reBuildIf(ir, (IfStmt) stmt, origStmts);
						newStmts.addAll(rebuildIfResult.getResult());
						break;
					default:
						newStmts.add(stmt);
						break;
				}
			}

			ir.stmts.clear();
			ir.stmts.addAll(newStmts);
		}
	}

	private RebuildIfResult reBuildIf(IrMethod ir, IfStmt ifStmt, List<Stmt> origStmts) {
		List<Stmt> newStmts = new ArrayList<>();

		int maxLocalIndex = 0;
		for (Local local : ir.locals) {
			maxLocalIndex = Math.max(maxLocalIndex, local._ls_index);
		}

		// if goto
		LBlock targetBlock = getIfTargetStmts(ifStmt);

		LBlock elseBlock = generateLBlock();

		Map<Integer, Integer> mapping = generateMapping();
		// add index
		// int obfIndex = random;
		Local obfIndex = Exprs.nLocal(ir.locals.size() + 2,"obf");
		obfIndex.valueType = "I";

		LBlock startBlock = generateLBlock();
		int obfIndexI = mapping.get(MAPPING_INDEX);
		newStmts.add(startBlock.getLabelStmt());
		newStmts.add(Stmts.nAssign(obfIndex, Exprs.nInt(obfIndexI ^ mapping.get(MAPPING_ENTER))));

		LabelStmt whileBegin = createWhile(newStmts);

		// 创建 ^ 操作
		newStmts.add(Stmts.nAssign(obfIndex, Exprs.nXor(obfIndex, Exprs.nInt(obfIndexI), "I")));

		LBlock fake = generateLBlock();
		fake.getStmts().add(Stmts.nAssign(obfIndex, obfIndex));
		fake.getStmts().add(Stmts.nGoto(whileBegin));

		// goto的跳板，由于没办法直接回到whileBegin并且计算obfIndex，所以需要此跳板来来操作.
		// 跳板将跳转回原goto
		LBlock gotoJumpBlock = generateLBlock();
		gotoJumpBlock.getStmts().add(Stmts.nAssign(obfIndex, Exprs.nInt(obfIndexI ^ mapping.get(MAPPING_GOTO))));
		gotoJumpBlock.getStmts().add(Stmts.nGoto(whileBegin));

		LBlock enterBlock = generateLBlock();
		ifStmt.target = gotoJumpBlock.getLabelStmt();
		enterBlock.getStmts().add(ifStmt);
		enterBlock.getStmts().add(Stmts.nAssign(obfIndex, Exprs.nInt(obfIndexI ^ mapping.get(MAPPING_ELSE))));
		enterBlock.getStmts().add(Stmts.nGoto(whileBegin));

		// else块需要重跳回whileBegin，进行最后跳跃到nextStep
		elseBlock.getStmts().add(Stmts.nAssign(obfIndex, Exprs.nInt(obfIndexI ^ mapping.get(MAPPING_NEXT))));
		elseBlock.getStmts().add(Stmts.nGoto(whileBegin));

		LBlock nextBlock = generateLBlock();

		LBlock defaultTarget = generateLBlock();

		Map<Integer, LabelStmt> switchBlock = new HashMap<>();
		switchBlock.put(mapping.get(MAPPING_GOTO), targetBlock.getLabelStmt());
		switchBlock.put(mapping.get(MAPPING_ELSE), elseBlock.getLabelStmt());
		switchBlock.put(mapping.get(MAPPING_ENTER), enterBlock.getLabelStmt());
		switchBlock.put(mapping.get(MAPPING_NEXT), nextBlock.getLabelStmt());
		switchBlock.put(mapping.get(MAPPING_FAKE), fake.getLabelStmt());

		// switch(obfIndex)
		LookupSwitchStmt lookupSwitchStmt = Stmts.nLookupSwitch(obfIndex,
				switchBlock.keySet().stream().mapToInt(integer -> integer).toArray(),
				switchBlock.values().toArray(new LabelStmt[]{}),
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

	private LBlock generateLBlock() {
		return new LBlock();
	}

	private int random() {
		return new Random().nextInt(999999) + 100000;
	}

	private Map<Integer, Integer> generateMapping() {
		Map<Integer, Integer> mapping = new HashMap<>();
		int index = random();
		mapping.put(MAPPING_INDEX, index);
		mapping.put(MAPPING_GOTO, random());
		mapping.put(MAPPING_ELSE, random());
		mapping.put(MAPPING_ENTER, random());
		mapping.put(MAPPING_NEXT, random());
		mapping.put(MAPPING_FAKE, random());

		Set<Integer> set = new HashSet<>();
		for (Integer value : mapping.values()) {
			if (set.contains(value)) {
				return generateMapping();
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
