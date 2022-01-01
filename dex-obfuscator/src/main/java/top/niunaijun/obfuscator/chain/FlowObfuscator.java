package top.niunaijun.obfuscator.chain;

import com.googlecode.dex2jar.ir.IrMethod;
import com.googlecode.dex2jar.ir.Trap;
import com.googlecode.dex2jar.ir.expr.*;
import com.googlecode.dex2jar.ir.stmt.LabelStmt;
import com.googlecode.dex2jar.ir.stmt.LookupSwitchStmt;
import com.googlecode.dex2jar.ir.stmt.Stmt;
import com.googlecode.dex2jar.ir.stmt.Stmts;
import top.niunaijun.obfuscator.LBlock;
import top.niunaijun.obfuscator.ObfuscatorConfiguration;
import top.niunaijun.obfuscator.RebuildIfResult;
import top.niunaijun.obfuscator.chain.base.BaseObfuscatorChain;

import java.util.*;

public class FlowObfuscator extends BaseObfuscatorChain {

	public FlowObfuscator(ObfuscatorConfiguration obfuscatorConfiguration) {
		super(obfuscatorConfiguration);
	}

	@Override
	public boolean canDepth() {
		return false;
	}

	@Override
	public boolean canHandle(IrMethod ir, Stmt stmt) {
		return true;
	}

	@Override
	public RebuildIfResult reBuild0(IrMethod ir, Stmt stmt, List<Stmt> origStmts) {
		return null;
	}

	@Override
	public void reBuildEnd(IrMethod ir, List<Stmt> newStmts, List<Stmt> origStmts) {
		if (ir.traps.size() > 0 || ir.name.equals("<init>")) {
			newStmts.addAll(origStmts);
			return;
		}
		List<Stmt> orig = new ArrayList<>(origStmts);
		boolean existCallSuper = false;
		List<Stmt> tmp = new ArrayList<>();
		int max = 3;
		for (int i = 0; i < max; i++) {
			if (i > orig.size() - 1) {
				break;
			}
			Stmt stmt = orig.get(i);
			if (stmt.st == Stmt.ST.IDENTITY) {
				max++;
			}
			tmp.add(stmt);
			existCallSuper = isCallSuper(stmt);
			if (existCallSuper) {
				break;
			}
		}
		if (!existCallSuper) {
			orig = new ArrayList<>(origStmts);
		} else {
			newStmts.addAll(tmp);
			for (Stmt stmt : tmp) {
				orig.remove(stmt);
			}
		}

		for (Stmt origStmt : orig) {
			if (origStmt.st == Stmt.ST.ASSIGN || origStmt.st == Stmt.ST.IDENTITY) {
				Stmt.E2Stmt e2Stmt = (Stmt.E2Stmt) origStmt;
				Value op1 = e2Stmt.getOp1();
				if (op1.vt == Value.VT.LOCAL) {
					Local local1 = (Local) op1;
					if (e2Stmt.getOp2().vt != Value.VT.THIS_REF && e2Stmt.getOp2().vt != Value.VT.PARAMETER_REF) {
						local1._ls_index = newLocal("new_local", e2Stmt.getOp2().valueType)._ls_index;
						newStmts.add(Stmts.nAssign(local1, getNullValue(e2Stmt.getOp2())));
					}
				}
			}
		}

		Local obfIndexFinal = newLocal("obf_index_final", "I");
		Local obfIndex = newLocal("obf_index", "I");
		Local obfStrHash = newLocal("obf_hash", "I");
		Local obfStr = newLocal("obf_str", "Ljava/lang/String;");

		LBlock whileBlock = generateLBlock();

		List<LBlock> origBlocks = getAllBlock(ir.traps, orig);
		Map<Stmt, LBlock> origBlockMaps = new HashMap<>();
		for (LBlock origBlock : origBlocks) {
			origBlockMaps.put(origBlock.getLabelStmt(), origBlock);
		}

		Set<Stmt> exceptionBlock = new HashSet<>();
		for (LBlock origBlock : origBlocks) {
			if (origBlock.getTrap() != null) {
				exceptionBlock.addAll(Arrays.asList(origBlock.getTrap().handlers));
			}
		}


		List<LBlock> newBlocks = new LinkedList<>();
		LBlock lastBlock = null;
		for (LBlock lBlock : origBlocks) {
			String label = null;
			List<LBlock> tmpBlocks = new ArrayList<>();
			if (!exceptionBlock.contains(lBlock.getLabelStmt())) {
				for (Stmt stmt : lBlock.getStmts()) {
					if (isCallSuper(stmt)) {
						if (lastBlock != null) {
							lastBlock.getStmts().add(stmt);
							continue;
						}
					}
					LBlock newBlock = new LBlock();
					newBlock.getStmts().add(stmt);
					newBlock.setKey(randomString(depth));
					newBlock.setTrap(lBlock.getTrap());
					tmpBlocks.add(newBlock);
					if (label == null) {
						label = newBlock.getKey();
					}
					if (lastBlock != null) {
						lastBlock.setNextKey(newBlock.getKey());
					}
					lastBlock = newBlock;
				}
				newBlocks.addAll(tmpBlocks);

				if (label != null) {
					lBlock.getStmts().clear();
					lBlock.getStmts().add(Stmts.nAssign(obfStr, Exprs.nString(label)));
					lBlock.getStmts().add(Stmts.nGoto(whileBlock.getLabelStmt()));
				}
			}
		}

		LBlock defaultTarget = generateLBlock();
		defaultTarget.getStmts().add(Stmts.nGoto(whileBlock.getLabelStmt()));

		LBlock enter = newBlocks.get(0);
		int obfIndexI = randomString(depth).hashCode();

		newStmts.add(Stmts.nAssign(obfIndexFinal, Exprs.nInt(obfIndexI)));
		newStmts.add(Stmts.nAssign(obfStr, Exprs.nString(enter.getKey())));
		newStmts.add(whileBlock.getLabelStmt());

		newStmts.add(Stmts.nAssign(obfStrHash, hashInvoke(obfStr)));
		newStmts.add(Stmts.nAssign(obfIndex, Exprs.nXor(obfIndexFinal, obfStrHash, "I")));

		Map<Integer, LabelStmt> switchBlock = new LinkedHashMap<>();

		for (LBlock newBlock : newBlocks) {
			switchBlock.put(newBlock.getKey().hashCode() ^ obfIndexI, newBlock.getLabelStmt());
		}
		LookupSwitchStmt lookupSwitchStmt = Stmts.nLookupSwitch(obfIndex,
				switchBlock.keySet().stream().mapToInt(integer -> integer).toArray(),
				switchBlock.values().toArray(new LabelStmt[]{}),
				defaultTarget.getLabelStmt());

		newStmts.add(lookupSwitchStmt);

		newStmts.add(defaultTarget.getLabelStmt());
		newStmts.addAll(defaultTarget.getStmts());

		for (LBlock newBlock : newBlocks) {
			newStmts.add(newBlock.getLabelStmt());
			newStmts.addAll(newBlock.getStmts());

			if (newBlock.getNextKey().length() != 0) {
				Stmt stmt = newBlock.getStmts().get(newBlock.getStmts().size() - 1);
				if (stmt.st != Stmt.ST.GOTO && stmt.st != Stmt.ST.RETURN && stmt.st != Stmt.ST.THROW) {
					newStmts.addAll(newBlock.getStmts());
					newStmts.add(Stmts.nAssign(obfStr, Exprs.nString(newBlock.getNextKey())));
					newStmts.add(Stmts.nGoto(whileBlock.getLabelStmt()));
				}
			}
		}

		for (LBlock origBlock : origBlocks) {
			newStmts.add(origBlock.getLabelStmt());
			if (!exceptionBlock.contains(origBlock.getLabelStmt())) {
				newStmts.addAll(origBlock.getStmts());
			} else {
				newStmts.add(Stmts.nAssign(obfStr, obfStr));
			}
		}
	}

	private boolean isCallSuper(Stmt stmt) {
		if (stmt.st == Stmt.ST.VOID_INVOKE) {
			Stmt.E1Stmt e1Stmt = (Stmt.E1Stmt) stmt;
			InvokeExpr expr = (InvokeExpr) e1Stmt.getOp();
			return "<init>".equals(expr.method.getName());
		}
		return false;
	}

	private InvokeExpr hashInvoke(Local strLocal) {
		return Exprs.nInvokeVirtual(new Value[]{strLocal}, "Ljava/lang/String;","hashCode", new String[]{}, "I");
	}

	private LBlock generateLBlock() {
		return new LBlock();
	}

	private List<LBlock> getAllBlock(List<Trap> traps, List<Stmt> origStmts) {
		List<LBlock> blocks = new ArrayList<>();
		LBlock lBlock = new LBlock();
		Trap trap = null;
		for (Stmt origStmt : origStmts) {
			if (origStmt.st == Stmt.ST.LABEL) {
				for (Trap t : traps) {
					if (t.start == origStmt || t.end == origStmt) {
						trap = t;
						break;
					} else {
						trap = null;
					}
				}
				blocks.add(lBlock);
				lBlock = new LBlock((LabelStmt) origStmt);
				if (trap != null) {
					lBlock.setTrap(trap);
				}
			} else {
				lBlock.getStmts().add(origStmt);
			}
		}
		blocks.add(lBlock);
		return blocks;
	}

	private Value getNullValue(Value value) {
		Constant constant = null;
		switch (value.valueType) {
			case "I":
				constant = Exprs.nInt(0);
				break;
			case "S":
				constant = Exprs.nShort((short) 0);
				break;
			case "J":
				constant = Exprs.nLong(0);
				break;
			case "F":
				constant = Exprs.nFloat(0);
				break;
			case "D":
				constant = Exprs.nDouble(0);
				break;
			case "C":
				constant = Exprs.nChar((char) 0);
				break;
			case "B":
				constant = Exprs.nByte((byte) 0);
				break;
			case "Z":
				constant = new Constant(false);
				break;
		}
		if (constant == null) {
			constant = new Constant(Constant.Null);
		}
		constant.valueType = value.valueType;
		return constant;
	}
}
