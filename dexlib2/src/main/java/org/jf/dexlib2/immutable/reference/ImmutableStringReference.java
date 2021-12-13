

package org.jf.dexlib2.immutable.reference;



import org.jf.dexlib2.base.reference.BaseStringReference;
import org.jf.dexlib2.iface.reference.StringReference;

public class ImmutableStringReference extends BaseStringReference implements ImmutableReference {

    protected final String str;

    public ImmutableStringReference(String str) {
        this.str = str;
    }


    public static ImmutableStringReference of(StringReference stringReference) {
        if (stringReference instanceof ImmutableStringReference) {
            return (ImmutableStringReference) stringReference;
        }
        return new ImmutableStringReference(stringReference.getString());
    }


    @Override
    public String getString() {
        return str;
    }
}
