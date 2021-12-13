

package org.jf.dexlib2.immutable;




import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import org.jf.dexlib2.base.BaseMethodParameter;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

import java.util.Set;

public class ImmutableMethodParameter extends BaseMethodParameter {
    
    protected final String type;
    
    protected final ImmutableSet<? extends ImmutableAnnotation> annotations;

    protected final String name;

    public ImmutableMethodParameter(String type,
                                    Set<? extends Annotation> annotations,
                                    String name) {
        this.type = type;
        this.annotations = ImmutableAnnotation.immutableSetOf(annotations);
        this.name = name;
    }

    public ImmutableMethodParameter(String type,
                                    ImmutableSet<? extends ImmutableAnnotation> annotations,
                                    String name) {
        this.type = type;
        this.annotations = ImmutableUtils.nullToEmptySet(annotations);
        this.name = name;
    }

    public static ImmutableMethodParameter of(MethodParameter methodParameter) {
        if (methodParameter instanceof ImmutableMethodParameter) {
            return (ImmutableMethodParameter) methodParameter;
        }
        return new ImmutableMethodParameter(
                methodParameter.getType(),
                methodParameter.getAnnotations(),
                methodParameter.getName());
    }

    
    @Override
    public String getType() {
        return type;
    }

    
    @Override
    public Set<? extends Annotation> getAnnotations() {
        return annotations;
    }


    @Override
    public String getName() {
        return name;
    }

    //TODO: iterate over the annotations to get the signature

    @Override
    public String getSignature() {
        return null;
    }

    
    public static ImmutableList<ImmutableMethodParameter> immutableListOf(
            Iterable<? extends MethodParameter> list) {
        return CONVERTER.toList(list);
    }

    private static final ImmutableConverter<ImmutableMethodParameter, MethodParameter> CONVERTER =
            new ImmutableConverter<ImmutableMethodParameter, MethodParameter>() {
                @Override
                protected boolean isImmutable(MethodParameter item) {
                    return item instanceof ImmutableMethodParameter;
                }

                
                @Override
                protected ImmutableMethodParameter makeImmutable(MethodParameter item) {
                    return ImmutableMethodParameter.of(item);
                }
            };
}
