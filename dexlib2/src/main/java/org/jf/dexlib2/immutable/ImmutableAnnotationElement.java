

package org.jf.dexlib2.immutable;




import com.google.common.collect.ImmutableSet;

import org.jf.dexlib2.base.BaseAnnotationElement;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValueFactory;
import org.jf.util.ImmutableConverter;

public class ImmutableAnnotationElement extends BaseAnnotationElement {

    protected final String name;

    protected final ImmutableEncodedValue value;

    public ImmutableAnnotationElement(String name,
                                      EncodedValue value) {
        this.name = name;
        this.value = ImmutableEncodedValueFactory.of(value);
    }

    public ImmutableAnnotationElement(String name,
                                      ImmutableEncodedValue value) {
        this.name = name;
        this.value = value;
    }

    public static ImmutableAnnotationElement of(AnnotationElement annotationElement) {
        if (annotationElement instanceof ImmutableAnnotationElement) {
            return (ImmutableAnnotationElement) annotationElement;
        }
        return new ImmutableAnnotationElement(
                annotationElement.getName(),
                annotationElement.getValue());
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public EncodedValue getValue() {
        return value;
    }


    public static ImmutableSet<ImmutableAnnotationElement> immutableSetOf(
            Iterable<? extends AnnotationElement> list) {
        return CONVERTER.toSet(list);
    }

    private static final ImmutableConverter<ImmutableAnnotationElement, AnnotationElement> CONVERTER =
            new ImmutableConverter<ImmutableAnnotationElement, AnnotationElement>() {
                @Override
                protected boolean isImmutable(AnnotationElement item) {
                    return item instanceof ImmutableAnnotationElement;
                }


                @Override
                protected ImmutableAnnotationElement makeImmutable(AnnotationElement item) {
                    return ImmutableAnnotationElement.of(item);
                }
            };
}
