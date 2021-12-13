

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.ReferenceType;
import org.jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction20bc extends ImmutableInstruction implements Instruction20bc {
    public static final Format FORMAT = Format.Format20bc;

    protected final int verificationError;

    protected final ImmutableReference reference;

    public ImmutableInstruction20bc(Opcode opcode,
                                    int verificationError,
                                    Reference reference) {
        super(opcode);
        this.verificationError = Preconditions.checkVerificationError(verificationError);
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction20bc of(Instruction20bc instruction) {
        if (instruction instanceof ImmutableInstruction20bc) {
            return (ImmutableInstruction20bc) instruction;
        }
        return new ImmutableInstruction20bc(
                instruction.getOpcode(),
                instruction.getVerificationError(),
                instruction.getReference());
    }

    @Override
    public int getVerificationError() {
        return verificationError;
    }


    @Override
    public ImmutableReference getReference() {
        return reference;
    }

    @Override
    public int getReferenceType() {
        return ReferenceType.getReferenceType(reference);
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
