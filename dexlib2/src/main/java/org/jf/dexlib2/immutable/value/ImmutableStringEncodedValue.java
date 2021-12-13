

package org.jf.dexlib2.immutable.value;



import org.jf.dexlib2.base.value.BaseStringEncodedValue;
import org.jf.dexlib2.iface.value.StringEncodedValue;

public class ImmutableStringEncodedValue extends BaseStringEncodedValue implements ImmutableEncodedValue {

    protected final String value;

    public ImmutableStringEncodedValue(String value) {
        this.value = value;
    }

    public static ImmutableStringEncodedValue of(StringEncodedValue stringEncodedValue) {
        if (stringEncodedValue instanceof ImmutableStringEncodedValue) {
            return (ImmutableStringEncodedValue) stringEncodedValue;
        }
        return new ImmutableStringEncodedValue(stringEncodedValue.getValue());
    }


    @Override
    public String getValue() {
        return value;
    }
}
