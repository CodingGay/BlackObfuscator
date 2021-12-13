

package org.jf.dexlib2.immutable.value;



import org.jf.dexlib2.base.value.BaseFieldEncodedValue;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.value.FieldEncodedValue;

public class ImmutableFieldEncodedValue extends BaseFieldEncodedValue implements ImmutableEncodedValue {
    
    protected final FieldReference value;

    public ImmutableFieldEncodedValue(FieldReference value) {
        this.value = value;
    }

    public static ImmutableFieldEncodedValue of(FieldEncodedValue fieldEncodedValue) {
        if (fieldEncodedValue instanceof ImmutableFieldEncodedValue) {
            return (ImmutableFieldEncodedValue) fieldEncodedValue;
        }
        return new ImmutableFieldEncodedValue(fieldEncodedValue.getValue());
    }

    
    @Override
    public FieldReference getValue() {
        return value;
    }
}
