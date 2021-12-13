

package org.jf.dexlib2.immutable.value;



import org.jf.dexlib2.base.value.BaseEnumEncodedValue;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.value.EnumEncodedValue;

public class ImmutableEnumEncodedValue extends BaseEnumEncodedValue implements ImmutableEncodedValue {

    protected final FieldReference value;

    public ImmutableEnumEncodedValue(FieldReference value) {
        this.value = value;
    }

    public static ImmutableEnumEncodedValue of(EnumEncodedValue enumEncodedValue) {
        if (enumEncodedValue instanceof ImmutableEnumEncodedValue) {
            return (ImmutableEnumEncodedValue) enumEncodedValue;
        }
        return new ImmutableEnumEncodedValue(enumEncodedValue.getValue());
    }


    @Override
    public FieldReference getValue() {
        return value;
    }
}
