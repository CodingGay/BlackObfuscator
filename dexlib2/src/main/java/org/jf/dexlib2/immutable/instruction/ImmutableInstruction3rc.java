

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rc;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction3rc extends ImmutableInstruction implements Instruction3rc {
    public static final Format FORMAT = Format.Format3rc;

    protected final int startRegister;
    protected final int registerCount;


    protected final ImmutableReference reference;

    public ImmutableInstruction3rc(Opcode opcode,
                                   int startRegister,
                                   int registerCount,
                                   Reference reference) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(startRegister);
        this.registerCount = Preconditions.checkRegisterRangeCount(registerCount);
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction3rc of(Instruction3rc instruction) {
        if (instruction instanceof ImmutableInstruction3rc) {
            return (ImmutableInstruction3rc) instruction;
        }
        return new ImmutableInstruction3rc(
                instruction.getOpcode(),
                instruction.getStartRegister(),
                instruction.getRegisterCount(),
                instruction.getReference());
    }

    @Override
    public int getStartRegister() {
        return startRegister;
    }

    @Override
    public int getRegisterCount() {
        return registerCount;
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

