package top.niunaijun.obfuscator.chain.base;

import com.googlecode.dex2jar.ir.IrMethod;
import com.googlecode.dex2jar.ir.stmt.Stmt;
import top.niunaijun.obfuscator.RebuildIfResult;

import java.util.List;

public interface ObfuscatorChain {
    boolean canHandle(IrMethod ir, Stmt stmt);

    RebuildIfResult reBuild(IrMethod ir, Stmt stmt, List<Stmt> origStmts, int depth);
}
