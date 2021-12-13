

package org.jf.dexlib2.immutable.reference;



import org.jf.dexlib2.base.reference.BaseFieldReference;
import org.jf.dexlib2.iface.reference.FieldReference;

public class ImmutableFieldReference extends BaseFieldReference implements ImmutableReference {
    
    protected final String definingClass;
    
    protected final String name;
    
    protected final String type;

    public ImmutableFieldReference(String definingClass,
                                   String name,
                                   String type) {
        this.definingClass = definingClass;
        this.name = name;
        this.type = type;
    }

    
    public static ImmutableFieldReference of(FieldReference fieldReference) {
        if (fieldReference instanceof ImmutableFieldReference) {
            return (ImmutableFieldReference) fieldReference;
        }
        return new ImmutableFieldReference(
                fieldReference.getDefiningClass(),
                fieldReference.getName(),
                fieldReference.getType());
    }

    
    public String getDefiningClass() {
        return definingClass;
    }

    
    public String getName() {
        return name;
    }

    
    public String getType() {
        return type;
    }
}
