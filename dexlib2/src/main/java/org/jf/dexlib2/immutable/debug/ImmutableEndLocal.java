

package org.jf.dexlib2.immutable.debug;




import org.jf.dexlib2.DebugItemType;
import org.jf.dexlib2.iface.debug.EndLocal;

public class ImmutableEndLocal extends ImmutableDebugItem implements EndLocal {
    protected final int register;

    protected final String name;

    protected final String type;

    protected final String signature;

    public ImmutableEndLocal(int codeAddress,
                             int register) {
        super(codeAddress);
        this.register = register;
        this.name = null;
        this.type = null;
        this.signature = null;
    }

    public ImmutableEndLocal(int codeAddress,
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


    public static ImmutableEndLocal of(EndLocal endLocal) {
        if (endLocal instanceof ImmutableEndLocal) {
            return (ImmutableEndLocal) endLocal;
        }
        return new ImmutableEndLocal(
                endLocal.getCodeAddress(),
                endLocal.getRegister(),
                endLocal.getType(),
                endLocal.getName(),
                endLocal.getSignature());
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
        return DebugItemType.END_LOCAL;
    }
}
