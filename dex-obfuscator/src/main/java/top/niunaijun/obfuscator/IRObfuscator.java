package top.niunaijun.obfuscator;

import com.googlecode.dex2jar.ir.IrMethod;
import com.googlecode.dex2jar.ir.stmt.*;
import top.niunaijun.obfuscator.chain.FlowObfuscator;
import top.niunaijun.obfuscator.chain.IfObfuscator;
import top.niunaijun.obfuscator.chain.SubObfuscator;
import top.niunaijun.obfuscator.chain.base.ObfuscatorChain;

import java.util.*;

public class IRObfuscator {

	private static IRObfuscator obfuscator;
	private final ObfuscatorConfiguration configuration;
	private final List<ObfuscatorChain> chains;

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
		this.chains = new LinkedList<>();
		this.chains.add(new FlowObfuscator(configuration));
		this.chains.add(new SubObfuscator(configuration));
		this.chains.add(new IfObfuscator(configuration));
	}

	public void reBuildInstructions(IrMethod ir) {
		if (configuration == null)
			return;
		if (!configuration.accept(ir.owner, ir.name)) {
			return;
		}

		for (ObfuscatorChain chain : chains) {
			for (int i = 0; i < configuration.getObfDepth(); i++) {
				List<Stmt> newStmts = new ArrayList<>();
				List<Stmt> origStmts = new ArrayList<>();
				for (Stmt value : ir.stmts) {
					origStmts.add(value);
				}
				RebuildIfResult rebuildIfResult;
				for (Stmt stmt : ir.stmts) {
					if (chain.canHandle(ir, stmt)) {
						rebuildIfResult = chain.reBuild(ir, stmt, origStmts);
						if (rebuildIfResult != null) {
							newStmts.addAll(rebuildIfResult.getResult());
						}
					} else {
						newStmts.add(stmt);
					}
				}
				chain.reBuildEnd(ir, newStmts, origStmts);
				ir.stmts.clear();
				ir.stmts.addAll(newStmts);
				if (!chain.canDepth()) {
					break;
				}
			}
		}
	}
}
