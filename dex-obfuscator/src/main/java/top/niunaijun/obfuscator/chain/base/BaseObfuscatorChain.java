package top.niunaijun.obfuscator.chain.base;

import com.googlecode.dex2jar.ir.IrMethod;
import com.googlecode.dex2jar.ir.expr.Exprs;
import com.googlecode.dex2jar.ir.expr.Local;
import com.googlecode.dex2jar.ir.stmt.Stmt;
import top.niunaijun.obfuscator.ObfDic;
import top.niunaijun.obfuscator.RebuildIfResult;

import java.util.List;
import java.util.Random;

public abstract class BaseObfuscatorChain implements ObfuscatorChain {

    private int localIndex;
    private IrMethod irMethod;

    public abstract RebuildIfResult reBuild0(IrMethod ir, Stmt stmt, List<Stmt> origStmts, int depth);

    @Override
    public final RebuildIfResult reBuild(IrMethod ir, Stmt stmt, List<Stmt> origStmts, int depth) {
        localIndex = ir.locals.size() * 2;
        irMethod = ir;
        return reBuild0(ir, stmt, origStmts, depth);
    }

    public Local newLocal(String name, String type) {
        Local local = Exprs.nLocal(++localIndex, name);
        local.valueType = type;
        irMethod.locals.add(local);
        return local;
    }

    public String randomString(int depth) {
        int length = new Random().nextInt(5 * depth);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(ObfDic.dic[new Random().nextInt(ObfDic.dic.length - 1)]);
        }
        return stringBuilder.toString();
    }
}
