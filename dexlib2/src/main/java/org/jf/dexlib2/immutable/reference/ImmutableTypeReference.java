

package org.jf.dexlib2.immutable.reference;




import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.util.ImmutableConverter;

import java.util.List;

public class ImmutableTypeReference extends BaseTypeReference implements ImmutableReference {

    protected final String type;

    public ImmutableTypeReference(String type) {
        this.type = type;
    }


    public static ImmutableTypeReference of(TypeReference typeReference) {
        if (typeReference instanceof ImmutableTypeReference) {
            return (ImmutableTypeReference) typeReference;
        }
        return new ImmutableTypeReference(typeReference.getType());
    }


    @Override
    public String getType() {
        return type;
    }


    public static ImmutableList<ImmutableTypeReference> immutableListOf(List<? extends TypeReference> list) {
        return CONVERTER.toList(list);
    }

    private static final ImmutableConverter<ImmutableTypeReference, TypeReference> CONVERTER =
            new ImmutableConverter<ImmutableTypeReference, TypeReference>() {
                @Override
                protected boolean isImmutable(TypeReference item) {
                    return item instanceof ImmutableTypeReference;
                }


                @Override
                protected ImmutableTypeReference makeImmutable(TypeReference item) {
                    return ImmutableTypeReference.of(item);
                }
            };
}
