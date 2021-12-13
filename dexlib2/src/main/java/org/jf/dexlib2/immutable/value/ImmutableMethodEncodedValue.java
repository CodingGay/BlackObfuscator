

package org.jf.dexlib2.immutable.value;



import org.jf.dexlib2.base.value.BaseMethodEncodedValue;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.value.MethodEncodedValue;

public class ImmutableMethodEncodedValue extends BaseMethodEncodedValue implements ImmutableEncodedValue {

    protected final MethodReference value;

    public ImmutableMethodEncodedValue(MethodReference value) {
        this.value = value;
    }

    public static ImmutableMethodEncodedValue of(MethodEncodedValue methodEncodedValue) {
        if (methodEncodedValue instanceof ImmutableMethodEncodedValue) {
            return (ImmutableMethodEncodedValue) methodEncodedValue;
        }
        return new ImmutableMethodEncodedValue(methodEncodedValue.getValue());
    }


    @Override
    public MethodReference getValue() {
        return value;
    }
}
