

package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseShortEncodedValue;
import org.jf.dexlib2.iface.value.ShortEncodedValue;

public class ImmutableShortEncodedValue extends BaseShortEncodedValue implements ImmutableEncodedValue {
    protected final short value;

    public ImmutableShortEncodedValue(short value) {
        this.value = value;
    }

    public static ImmutableShortEncodedValue of(ShortEncodedValue shortEncodedValue) {
        if (shortEncodedValue instanceof ImmutableShortEncodedValue) {
            return (ImmutableShortEncodedValue) shortEncodedValue;
        }
        return new ImmutableShortEncodedValue(shortEncodedValue.getValue());
    }

    @Override
    public short getValue() {
        return value;
    }
}
