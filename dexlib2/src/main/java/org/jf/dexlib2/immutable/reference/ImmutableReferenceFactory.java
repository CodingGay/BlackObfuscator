

package org.jf.dexlib2.immutable.reference;



import org.jf.dexlib2.ReferenceType;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.util.ExceptionWithContext;

public class ImmutableReferenceFactory {
    
    public static ImmutableReference of(Reference reference) {
        if (reference instanceof StringReference) {
            return ImmutableStringReference.of((StringReference) reference);
        }
        if (reference instanceof TypeReference) {
            return ImmutableTypeReference.of((TypeReference) reference);
        }
        if (reference instanceof FieldReference) {
            return ImmutableFieldReference.of((FieldReference) reference);
        }
        if (reference instanceof MethodReference) {
            return ImmutableMethodReference.of((MethodReference) reference);
        }
        if (reference instanceof MethodProtoReference) {
            return ImmutableMethodProtoReference.of((MethodProtoReference) reference);
        }
        throw new ExceptionWithContext("Invalid reference type");
    }

    
    public static ImmutableReference of(int referenceType, Reference reference) {
        switch (referenceType) {
            case ReferenceType.STRING:
                return ImmutableStringReference.of((StringReference) reference);
            case ReferenceType.TYPE:
                return ImmutableTypeReference.of((TypeReference) reference);
            case ReferenceType.FIELD:
                return ImmutableFieldReference.of((FieldReference) reference);
            case ReferenceType.METHOD:
                return ImmutableMethodReference.of((MethodReference) reference);
            case ReferenceType.METHOD_PROTO:
                return ImmutableMethodProtoReference.of((MethodProtoReference) reference);
        }
        throw new ExceptionWithContext("Invalid reference type: %d", referenceType);
    }
}
