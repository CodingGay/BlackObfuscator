

package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseNullEncodedValue;

public class ImmutableNullEncodedValue extends BaseNullEncodedValue implements ImmutableEncodedValue {
    public static final ImmutableNullEncodedValue INSTANCE = new ImmutableNullEncodedValue();

    private ImmutableNullEncodedValue() {
    }
}
