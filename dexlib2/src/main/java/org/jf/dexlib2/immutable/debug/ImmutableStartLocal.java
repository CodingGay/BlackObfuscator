

package org.jf.dexlib2.immutable.debug;




import org.jf.dexlib2.DebugItemType;
import org.jf.dexlib2.base.reference.BaseStringReference;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.UpdateReference;
import org.jf.dexlib2.iface.debug.StartLocal;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.dexlib2.writer.builder.DexBuilder;

public class ImmutableStartLocal extends ImmutableDebugItem implements StartLocal, UpdateReference {
    protected final int register;

    protected final String name;

    protected final String type;

    protected final String signature;


    public ImmutableStartLocal(int codeAddress,
                               int register,
                               String name,
                               String type,
                               String signature) {
        super(codeAddress);
        this.register = register;
        this.name = name;
        this.type = type;
        this.signature = signature;
    }

    
    public static ImmutableStartLocal of(StartLocal startLocal) {
        if (startLocal instanceof ImmutableStartLocal) {
            return (ImmutableStartLocal) startLocal;
        }
        return new ImmutableStartLocal(
                startLocal.getCodeAddress(),
                startLocal.getRegister(),
                startLocal.getName(),
                startLocal.getType(),
                startLocal.getSignature());
    }

    @Override
    public int getRegister() {
        return register;
    }


    @Override
    public StringReference getNameReference() {
        if (nameRef != null)
            return nameRef;
        return name == null ? null : new BaseStringReference() {
            
            @Override
            public String getString() {
                return name;
            }
        };
    }


    @Override
    public TypeReference getTypeReference() {
        if (typeRef != null)
            return typeRef;
        return type == null ? null : new BaseTypeReference() {
            
            @Override
            public String getType() {
                return type;
            }
        };
    }


    @Override
    public StringReference getSignatureReference() {
        if (signatureRef != null)
            return signatureRef;
        return signature == null ? null : new BaseStringReference() {
            
            @Override
            public String getString() {
                return signature;
            }
        };
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
    public String getSignature() {
        return signature;
    }

    @Override
    public int getDebugItemType() {
        return DebugItemType.START_LOCAL;
    }


    private StringReference nameRef;

    private TypeReference typeRef;

    private StringReference signatureRef;

    @Override
    public void updateReference(DexBuilder dexBuilder) {
        nameRef = dexBuilder.internNullableStringReference(name);
        signatureRef = dexBuilder.internNullableStringReference(signature);
        typeRef = dexBuilder.internNullableTypeReference(type);
    }
}
