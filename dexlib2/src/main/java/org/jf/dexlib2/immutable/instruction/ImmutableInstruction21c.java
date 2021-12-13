

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction21c;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction21c extends ImmutableInstruction implements Instruction21c {
    public static final Format FORMAT = Format.Format21c;

    protected final int registerA;
    
    protected final ImmutableReference reference;

    public ImmutableInstruction21c(Opcode opcode,
                                   int registerA,
                                   Reference reference) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(registerA);
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction21c of(Instruction21c instruction) {
        if (instruction instanceof ImmutableInstruction21c) {
            return (ImmutableInstruction21c) instruction;
        }
        return new ImmutableInstruction21c(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getReference());
    }

    @Override
    public int getRegisterA() {
        return registerA;
    }

    
    @Override
    public ImmutableReference getReference() {
        return reference;
    }

    @Override
    public int getReferenceType() {
        return opcode.referenceType;
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
