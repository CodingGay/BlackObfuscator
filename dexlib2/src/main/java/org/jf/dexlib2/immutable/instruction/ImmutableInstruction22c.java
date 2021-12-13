

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22c;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction22c extends ImmutableInstruction implements Instruction22c {
    public static final Format FORMAT = Format.Format22c;

    protected final int registerA;
    protected final int registerB;
    
    protected final ImmutableReference reference;

    public ImmutableInstruction22c(Opcode opcode,
                                   int registerA,
                                   int registerB,
                                   Reference reference) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(registerA);
        this.registerB = Preconditions.checkNibbleRegister(registerB);
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction22c of(Instruction22c instruction) {
        if (instruction instanceof ImmutableInstruction22c) {
            return (ImmutableInstruction22c) instruction;
        }
        return new ImmutableInstruction22c(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getRegisterB(),
                instruction.getReference());
    }

    @Override
    public int getRegisterA() {
        return registerA;
    }

    @Override
    public int getRegisterB() {
        return registerB;
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