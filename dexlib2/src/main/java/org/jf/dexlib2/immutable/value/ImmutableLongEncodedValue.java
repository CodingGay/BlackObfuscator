

package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseLongEncodedValue;
import org.jf.dexlib2.iface.value.LongEncodedValue;

public class ImmutableLongEncodedValue extends BaseLongEncodedValue implements ImmutableEncodedValue {
    protected final long value;

    public ImmutableLongEncodedValue(long value) {
        this.value = value;
    }

    public static ImmutableLongEncodedValue of(LongEncodedValue longEncodedValue) {
        if (longEncodedValue instanceof ImmutableLongEncodedValue) {
            return (ImmutableLongEncodedValue) longEncodedValue;
        }
        return new ImmutableLongEncodedValue(longEncodedValue.getValue());
    }

    @Override
    public long getValue() {
        return value;
    }
}
