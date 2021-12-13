

package org.jf.dexlib2.immutable.value;




import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.ValueType;
import org.jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.BooleanEncodedValue;
import org.jf.dexlib2.iface.value.ByteEncodedValue;
import org.jf.dexlib2.iface.value.CharEncodedValue;
import org.jf.dexlib2.iface.value.DoubleEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.EnumEncodedValue;
import org.jf.dexlib2.iface.value.FieldEncodedValue;
import org.jf.dexlib2.iface.value.FloatEncodedValue;
import org.jf.dexlib2.iface.value.IntEncodedValue;
import org.jf.dexlib2.iface.value.LongEncodedValue;
import org.jf.dexlib2.iface.value.MethodEncodedValue;
import org.jf.dexlib2.iface.value.ShortEncodedValue;
import org.jf.dexlib2.iface.value.StringEncodedValue;
import org.jf.dexlib2.iface.value.TypeEncodedValue;
import org.jf.util.ExceptionWithContext;
import org.jf.util.ImmutableConverter;

public class ImmutableEncodedValueFactory {
    
    public static ImmutableEncodedValue of(EncodedValue encodedValue) {
        switch (encodedValue.getValueType()) {
            case ValueType.BYTE:
                return ImmutableByteEncodedValue.of((ByteEncodedValue) encodedValue);
            case ValueType.SHORT:
                return ImmutableShortEncodedValue.of((ShortEncodedValue) encodedValue);
            case ValueType.CHAR:
                return ImmutableCharEncodedValue.of((CharEncodedValue) encodedValue);
            case ValueType.INT:
                return ImmutableIntEncodedValue.of((IntEncodedValue) encodedValue);
            case ValueType.LONG:
                return ImmutableLongEncodedValue.of((LongEncodedValue) encodedValue);
            case ValueType.FLOAT:
                return ImmutableFloatEncodedValue.of((FloatEncodedValue) encodedValue);
            case ValueType.DOUBLE:
                return ImmutableDoubleEncodedValue.of((DoubleEncodedValue) encodedValue);
            case ValueType.STRING:
                return ImmutableStringEncodedValue.of((StringEncodedValue) encodedValue);
            case ValueType.TYPE:
                return ImmutableTypeEncodedValue.of((TypeEncodedValue) encodedValue);
            case ValueType.FIELD:
                return ImmutableFieldEncodedValue.of((FieldEncodedValue) encodedValue);
            case ValueType.METHOD:
                return ImmutableMethodEncodedValue.of((MethodEncodedValue) encodedValue);
            case ValueType.ENUM:
                return ImmutableEnumEncodedValue.of((EnumEncodedValue) encodedValue);
            case ValueType.ARRAY:
                return ImmutableArrayEncodedValue.of((ArrayEncodedValue) encodedValue);
            case ValueType.ANNOTATION:
                return ImmutableAnnotationEncodedValue.of((AnnotationEncodedValue) encodedValue);
            case ValueType.NULL:
                return ImmutableNullEncodedValue.INSTANCE;
            case ValueType.BOOLEAN:
                return ImmutableBooleanEncodedValue.of((BooleanEncodedValue) encodedValue);
            default:
                Preconditions.checkArgument(false);
                return null;
        }
    }

    
    public static EncodedValue defaultValueForType(String type) {
        switch (type.charAt(0)) {
            case 'Z':
                return ImmutableBooleanEncodedValue.FALSE_VALUE;
            case 'B':
                return new ImmutableByteEncodedValue((byte) 0);
            case 'S':
                return new ImmutableShortEncodedValue((short) 0);
            case 'C':
                return new ImmutableCharEncodedValue((char) 0);
            case 'I':
                return new ImmutableIntEncodedValue(0);
            case 'J':
                return new ImmutableLongEncodedValue(0);
            case 'F':
                return new ImmutableFloatEncodedValue(0);
            case 'D':
                return new ImmutableDoubleEncodedValue(0);
            case 'L':
            case '[':
                return ImmutableNullEncodedValue.INSTANCE;
            default:
                throw new ExceptionWithContext("Unrecognized type: %s", type);
        }
    }


    public static ImmutableEncodedValue ofNullable(EncodedValue encodedValue) {
        if (encodedValue == null) {
            return null;
        }
        return of(encodedValue);
    }

    
    public static ImmutableList<ImmutableEncodedValue> immutableListOf
            (Iterable<? extends EncodedValue> list) {
        return CONVERTER.toList(list);
    }

    private static final ImmutableConverter<ImmutableEncodedValue, EncodedValue> CONVERTER =
            new ImmutableConverter<ImmutableEncodedValue, EncodedValue>() {
                @Override
                protected boolean isImmutable(EncodedValue item) {
                    return item instanceof ImmutableEncodedValue;
                }

                
                @Override
                protected ImmutableEncodedValue makeImmutable(EncodedValue item) {
                    return of(item);
                }
            };
}
