

package org.jf.dexlib2.immutable;




import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;

import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

import java.util.Set;

public class ImmutableMethod extends BaseMethodReference implements Method {

    protected final String definingClass;

    protected final String name;

    protected final ImmutableList<? extends ImmutableMethodParameter> parameters;

    protected final String returnType;
    protected final int accessFlags;

    protected final ImmutableSet<? extends ImmutableAnnotation> annotations;

    protected final ImmutableMethodImplementation methodImplementation;

    public ImmutableMethod(String definingClass,
                           String name,
                           Iterable<? extends MethodParameter> parameters,
                           String returnType,
                           int accessFlags,
                           Set<? extends Annotation> annotations,
                           MethodImplementation methodImplementation) {
        this.definingClass = definingClass;
        this.name = name;
        this.parameters = ImmutableMethodParameter.immutableListOf(parameters);
        this.returnType = returnType;
        this.accessFlags = accessFlags;
        this.annotations = ImmutableAnnotation.immutableSetOf(annotations);
        this.methodImplementation = ImmutableMethodImplementation.of(methodImplementation);
    }

    public ImmutableMethod(String definingClass,
                           String name,
                           ImmutableList<? extends ImmutableMethodParameter> parameters,
                           String returnType,
                           int accessFlags,
                           ImmutableSet<? extends ImmutableAnnotation> annotations,
                           ImmutableMethodImplementation methodImplementation) {
        this.definingClass = definingClass;
        this.name = name;
        this.parameters = ImmutableUtils.nullToEmptyList(parameters);
        this.returnType = returnType;
        this.accessFlags = accessFlags;
        this.annotations = ImmutableUtils.nullToEmptySet(annotations);
        this.methodImplementation = methodImplementation;
    }

    public static ImmutableMethod of(Method method) {
        if (method instanceof ImmutableMethod) {
            return (ImmutableMethod) method;
        }
        return new ImmutableMethod(
                method.getDefiningClass(),
                method.getName(),
                method.getParameters(),
                method.getReturnType(),
                method.getAccessFlags(),
                method.getAnnotations(),
                method.getImplementation());
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

    public ImmutableList<? extends CharSequence> getParameterTypes() {
        return parameters;
    }

    @Override

    public ImmutableList<? extends ImmutableMethodParameter> getParameters() {
        return parameters;
    }

    @Override

    public String getReturnType() {
        return returnType;
    }

    @Override
    public int getAccessFlags() {
        return accessFlags;
    }

    @Override

    public ImmutableSet<? extends ImmutableAnnotation> getAnnotations() {
        return annotations;
    }

    @Override

    public ImmutableMethodImplementation getImplementation() {
        return methodImplementation;
    }


    public static ImmutableSortedSet<ImmutableMethod> immutableSetOf(Iterable<? extends Method> list) {
        return CONVERTER.toSortedSet(Ordering.natural(), list);
    }

    private static final ImmutableConverter<ImmutableMethod, Method> CONVERTER =
            new ImmutableConverter<ImmutableMethod, Method>() {
                @Override
                protected boolean isImmutable(Method item) {
                    return item instanceof ImmutableMethod;
                }


                @Override
                protected ImmutableMethod makeImmutable(Method item) {
                    return ImmutableMethod.of(item);
                }
            };
}
