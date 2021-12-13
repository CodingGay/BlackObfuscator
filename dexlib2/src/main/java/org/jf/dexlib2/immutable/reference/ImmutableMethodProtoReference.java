

package org.jf.dexlib2.immutable.reference;




import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.base.reference.BaseMethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.immutable.util.CharSequenceConverter;

import java.util.List;

public class ImmutableMethodProtoReference extends BaseMethodProtoReference implements ImmutableReference {

    protected final ImmutableList<String> parameters;

    protected final String returnType;

    public ImmutableMethodProtoReference(Iterable<? extends CharSequence> parameters,
                                         String returnType) {
        this.parameters = CharSequenceConverter.immutableStringList(parameters);
        this.returnType = returnType;
    }


    public static ImmutableMethodProtoReference of(MethodProtoReference methodProtoReference) {
        if (methodProtoReference instanceof ImmutableMethodProtoReference) {
            return (ImmutableMethodProtoReference) methodProtoReference;
        }
        return new ImmutableMethodProtoReference(
                methodProtoReference.getParameterTypes(),
                methodProtoReference.getReturnType());
    }

    @Override
    public List<? extends CharSequence> getParameterTypes() {
        return parameters;
    }

    @Override
    public String getReturnType() {
        return returnType;
    }
}
