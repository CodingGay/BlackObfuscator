

package org.jf.dexlib2.immutable.reference;




import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.immutable.util.CharSequenceConverter;
import org.jf.util.ImmutableUtils;

public class ImmutableMethodReference extends BaseMethodReference implements ImmutableReference {
    
    protected final String definingClass;
    
    protected final String name;
    
    protected final ImmutableList<String> parameters;
    
    protected final String returnType;

    public ImmutableMethodReference(String definingClass,
                                    String name,
                                    Iterable<? extends CharSequence> parameters,
                                    String returnType) {
        this.definingClass = definingClass;
        this.name = name;
        this.parameters = CharSequenceConverter.immutableStringList(parameters);
        this.returnType = returnType;
    }

    public ImmutableMethodReference(String definingClass,
                                    String name,
                                    ImmutableList<String> parameters,
                                    String returnType) {
        this.definingClass = definingClass;
        this.name = name;
        this.parameters = ImmutableUtils.nullToEmptyList(parameters);
        this.returnType = returnType;
    }

    
    public static ImmutableMethodReference of(MethodReference methodReference) {
        if (methodReference instanceof ImmutableMethodReference) {
            return (ImmutableMethodReference) methodReference;
        }
        return new ImmutableMethodReference(
                methodReference.getDefiningClass(),
                methodReference.getName(),
                methodReference.getParameterTypes(),
                methodReference.getReturnType());
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
    public ImmutableList<String> getParameterTypes() {
        return parameters;
    }

    
    @Override
    public String getReturnType() {
        return returnType;
    }


}
