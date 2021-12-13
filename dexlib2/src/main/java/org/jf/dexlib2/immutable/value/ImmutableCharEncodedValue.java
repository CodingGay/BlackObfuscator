

package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseCharEncodedValue;
import org.jf.dexlib2.iface.value.CharEncodedValue;

public class ImmutableCharEncodedValue extends BaseCharEncodedValue implements ImmutableEncodedValue {
    protected final char value;

    public ImmutableCharEncodedValue(char value) {
        this.value = value;
    }

    public static ImmutableCharEncodedValue of(CharEncodedValue charEncodedValue) {
        if (charEncodedValue instanceof ImmutableCharEncodedValue) {
            return (ImmutableCharEncodedValue) charEncodedValue;
        }
        return new ImmutableCharEncodedValue(charEncodedValue.getValue());
    }

    @Override
    public char getValue() {
        return value;
    }
}
