

package org.jf.dexlib2.immutable.debug;



import org.jf.dexlib2.DebugItemType;
import org.jf.dexlib2.iface.debug.PrologueEnd;

public class ImmutablePrologueEnd extends ImmutableDebugItem implements PrologueEnd {
    public ImmutablePrologueEnd(int codeAddress) {
        super(codeAddress);
    }


    public static ImmutablePrologueEnd of(PrologueEnd prologueEnd) {
        if (prologueEnd instanceof ImmutablePrologueEnd) {
            return (ImmutablePrologueEnd) prologueEnd;
        }
        return new ImmutablePrologueEnd(prologueEnd.getCodeAddress());
    }

    @Override
    public int getDebugItemType() {
        return DebugItemType.PROLOGUE_END;
    }
}
