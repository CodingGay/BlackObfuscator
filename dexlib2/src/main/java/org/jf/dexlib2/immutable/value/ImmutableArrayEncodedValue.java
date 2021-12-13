

package org.jf.dexlib2.immutable.value;



import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;

import java.util.Collection;

public class ImmutableArrayEncodedValue extends BaseArrayEncodedValue implements ImmutableEncodedValue {

    protected final ImmutableList<? extends ImmutableEncodedValue> value;

    public ImmutableArrayEncodedValue(Collection<? extends EncodedValue> value) {
        this.value = ImmutableEncodedValueFactory.immutableListOf(value);
    }

    public ImmutableArrayEncodedValue(ImmutableList<ImmutableEncodedValue> value) {
        this.value = value;
    }

    public static ImmutableArrayEncodedValue of(ArrayEncodedValue arrayEncodedValue) {
        if (arrayEncodedValue instanceof ImmutableArrayEncodedValue) {
            return (ImmutableArrayEncodedValue) arrayEncodedValue;
        }
        return new ImmutableArrayEncodedValue(arrayEncodedValue.getValue());
    }


    public ImmutableList<? extends ImmutableEncodedValue> getValue() {
        return value;
    }
}
