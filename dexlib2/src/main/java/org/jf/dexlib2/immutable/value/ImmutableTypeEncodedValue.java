

package org.jf.dexlib2.immutable.value;



import org.jf.dexlib2.base.value.BaseTypeEncodedValue;
import org.jf.dexlib2.iface.value.TypeEncodedValue;

public class ImmutableTypeEncodedValue extends BaseTypeEncodedValue implements ImmutableEncodedValue {
    
    protected final String value;

    public ImmutableTypeEncodedValue(String value) {
        this.value = value;
    }

    public static ImmutableTypeEncodedValue of(TypeEncodedValue typeEncodedValue) {
        if (typeEncodedValue instanceof ImmutableTypeEncodedValue) {
            return (ImmutableTypeEncodedValue) typeEncodedValue;
        }
        return new ImmutableTypeEncodedValue(typeEncodedValue.getValue());
    }

    
    @Override
    public String getValue() {
        return value;
    }
}
