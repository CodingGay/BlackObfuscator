package top.niunaijun.obfuscator;

import com.googlecode.dex2jar.ir.IrMethod;
import com.googlecode.dex2jar.ir.stmt.*;
import top.niunaijun.obfuscator.chain.IfObfuscator;
import top.niunaijun.obfuscator.chain.base.ObfuscatorChain;
import top.niunaijun.obfuscator.chain.SubObfuscator;

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
		this.chains.add(new SubObfuscator());
		this.chains.add(new IfObfuscator());
	}

	public void reBuildInstructions(IrMethod ir) {
		if (configuration == null)
			return;
		if (!configuration.accept(ir.owner, ir.name)) {
			return;
		}

		for (ObfuscatorChain chain : chains) {
			for (int i = 0; i < configuration.getObfDepth(); i++) {
				List<Stmt> origStmts = new ArrayList<>();
				List<Stmt> newStmts = new ArrayList<>();
				for (Stmt value : ir.stmts) {
					origStmts.add(value);
				}

				int depth = configuration.getObfDepth();
				RebuildIfResult rebuildIfResult;
				for (Stmt stmt : ir.stmts) {
					if (chain.canHandle(ir, stmt)) {
						rebuildIfResult = chain.reBuild(ir, stmt, origStmts, depth);
						newStmts.addAll(rebuildIfResult.getResult());
					} else {
						newStmts.add(stmt);
					}
				}

				ir.stmts.clear();
				ir.stmts.addAll(newStmts);
			}
		}
	}
}
