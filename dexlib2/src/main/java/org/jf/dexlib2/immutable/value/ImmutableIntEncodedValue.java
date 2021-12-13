

package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseIntEncodedValue;
import org.jf.dexlib2.iface.value.IntEncodedValue;

public class ImmutableIntEncodedValue extends BaseIntEncodedValue implements ImmutableEncodedValue {
    protected final int value;

    public ImmutableIntEncodedValue(int value) {
        this.value = value;
    }

    public static ImmutableIntEncodedValue of(IntEncodedValue intEncodedValue) {
        if (intEncodedValue instanceof ImmutableIntEncodedValue) {
            return (ImmutableIntEncodedValue) intEncodedValue;
        }
        return new ImmutableIntEncodedValue(intEncodedValue.getValue());
    }

    @Override
    public int getValue() {
        return value;
    }
}
