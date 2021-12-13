

package org.jf.dexlib2.immutable;




import com.google.common.collect.ImmutableSet;

import org.jf.dexlib2.base.BaseAnnotation;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

import java.util.Collection;

public class ImmutableAnnotation extends BaseAnnotation {
    protected final int visibility;
    
    protected final String type;
    
    protected final ImmutableSet<? extends ImmutableAnnotationElement> elements;

    public ImmutableAnnotation(int visibility,
                               String type,
                               Collection<? extends AnnotationElement> elements) {
        this.visibility = visibility;
        this.type = type;
        this.elements = ImmutableAnnotationElement.immutableSetOf(elements);
    }

    public ImmutableAnnotation(int visibility,
                               String type,
                               ImmutableSet<? extends ImmutableAnnotationElement> elements) {
        this.visibility = visibility;
        this.type = type;
        this.elements = ImmutableUtils.nullToEmptySet(elements);
    }

    public static ImmutableAnnotation of(Annotation annotation) {
        if (annotation instanceof ImmutableAnnotation) {
            return (ImmutableAnnotation) annotation;
        }
        return new ImmutableAnnotation(
                annotation.getVisibility(),
                annotation.getType(),
                annotation.getElements());
    }

    @Override
    public int getVisibility() {
        return visibility;
    }

    
    @Override
    public String getType() {
        return type;
    }

    
    @Override
    public ImmutableSet<? extends ImmutableAnnotationElement> getElements() {
        return elements;
    }

    
    public static ImmutableSet<ImmutableAnnotation> immutableSetOf(Iterable<? extends Annotation> list) {
        return CONVERTER.toSet(list);
    }

    private static final ImmutableConverter<ImmutableAnnotation, Annotation> CONVERTER =
            new ImmutableConverter<ImmutableAnnotation, Annotation>() {
                @Override
                protected boolean isImmutable(Annotation item) {
                    return item instanceof ImmutableAnnotation;
                }

                
                @Override
                protected ImmutableAnnotation makeImmutable(Annotation item) {
                    return ImmutableAnnotation.of(item);
                }
            };
}
