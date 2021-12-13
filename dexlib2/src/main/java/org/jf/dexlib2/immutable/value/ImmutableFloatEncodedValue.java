

package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseFloatEncodedValue;
import org.jf.dexlib2.iface.value.FloatEncodedValue;

public class ImmutableFloatEncodedValue extends BaseFloatEncodedValue implements ImmutableEncodedValue {
    protected final float value;

    public ImmutableFloatEncodedValue(float value) {
        this.value = value;
    }

    public static ImmutableFloatEncodedValue of(FloatEncodedValue floatEncodedValue) {
        if (floatEncodedValue instanceof ImmutableFloatEncodedValue) {
            return (ImmutableFloatEncodedValue) floatEncodedValue;
        }
        return new ImmutableFloatEncodedValue(floatEncodedValue.getValue());
    }

    @Override
    public float getValue() {
        return value;
    }
}
