

package org.jf.dexlib2.immutable;




import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;

import org.jf.dexlib2.base.reference.BaseFieldReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValueFactory;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

import java.util.Collection;

public class ImmutableField extends BaseFieldReference implements Field {

    protected final String definingClass;

    protected final String name;

    protected final String type;
    protected final int accessFlags;

    protected final ImmutableEncodedValue initialValue;

    protected final ImmutableSet<? extends ImmutableAnnotation> annotations;

    public ImmutableField(String definingClass,
                          String name,
                          String type,
                          int accessFlags,
                          EncodedValue initialValue,
                          Collection<? extends Annotation> annotations) {
        this.definingClass = definingClass;
        this.name = name;
        this.type = type;
        this.accessFlags = accessFlags;
        this.initialValue = ImmutableEncodedValueFactory.ofNullable(initialValue);
        this.annotations = ImmutableAnnotation.immutableSetOf(annotations);
    }

    public ImmutableField(String definingClass,
                          String name,
                          String type,
                          int accessFlags,
                          ImmutableEncodedValue initialValue,
                          ImmutableSet<? extends ImmutableAnnotation> annotations) {
        this.definingClass = definingClass;
        this.name = name;
        this.type = type;
        this.accessFlags = accessFlags;
        this.initialValue = initialValue;
        this.annotations = ImmutableUtils.nullToEmptySet(annotations);
    }

    public static ImmutableField of(Field field) {
        if (field instanceof ImmutableField) {
            return (ImmutableField) field;
        }
        return new ImmutableField(
                field.getDefiningClass(),
                field.getName(),
                field.getType(),
                field.getAccessFlags(),
                field.getInitialValue(),
                field.getAnnotations());
    }


    @Override
    public String getDefiningClass() {
        return definingClass;
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getAccessFlags() {
        return accessFlags;
    }

    @Override
    public EncodedValue getInitialValue() {
        return initialValue;
    }


    @Override
    public ImmutableSet<? extends ImmutableAnnotation> getAnnotations() {
        return annotations;
    }


    public static ImmutableSortedSet<ImmutableField> immutableSetOf(Iterable<? extends Field> list) {
        return CONVERTER.toSortedSet(Ordering.natural(), list);
    }

    private static final ImmutableConverter<ImmutableField, Field> CONVERTER =
            new ImmutableConverter<ImmutableField, Field>() {
                @Override
                protected boolean isImmutable(Field item) {
                    return item instanceof ImmutableField;
                }


                @Override
                protected ImmutableField makeImmutable(Field item) {
                    return ImmutableField.of(item);
                }
            };
}
