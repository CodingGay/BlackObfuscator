

package org.jf.dexlib2.immutable.debug;




import org.jf.dexlib2.DebugItemType;
import org.jf.dexlib2.iface.debug.RestartLocal;

public class ImmutableRestartLocal extends ImmutableDebugItem implements RestartLocal {
    protected final int register;

    protected final String name;

    protected final String type;

    protected final String signature;

    public ImmutableRestartLocal(int codeAddress,
                                 int register) {
        super(codeAddress);
        this.register = register;
        this.name = null;
        this.type = null;
        this.signature = null;
    }

    public ImmutableRestartLocal(int codeAddress,
                                 int register,
                                 String name,
                                 String type,
                                 String signature) {
        super(codeAddress);
        this.register = register;
        this.name = name;
        this.type = type;
        this.signature = signature;
    }


    public static ImmutableRestartLocal of(RestartLocal restartLocal) {
        if (restartLocal instanceof ImmutableRestartLocal) {
            return (ImmutableRestartLocal) restartLocal;
        }
        return new ImmutableRestartLocal(
                restartLocal.getCodeAddress(),
                restartLocal.getRegister(),
                restartLocal.getType(),
                restartLocal.getName(),
                restartLocal.getSignature());
    }

    @Override
    public int getRegister() {
        return register;
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getType() {
        return type;
    }


    @Override
    public String getSignature() {
        return signature;
    }

    @Override
    public int getDebugItemType() {
        return DebugItemType.RESTART_LOCAL;
    }
}
