

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction35c extends ImmutableInstruction implements Instruction35c {
    public static final Format FORMAT = Format.Format35c;

    protected final int registerCount;
    protected final int registerC;
    protected final int registerD;
    protected final int registerE;
    protected final int registerF;
    protected final int registerG;

    protected final ImmutableReference reference;

    public ImmutableInstruction35c(Opcode opcode,
                                   int registerCount,
                                   int registerC,
                                   int registerD,
                                   int registerE,
                                   int registerF,
                                   int registerG,
                                   Reference reference) {
        super(opcode);
        this.registerCount = Preconditions.check35cAnd45ccRegisterCount(registerCount);
        this.registerC = (registerCount > 0) ? Preconditions.checkNibbleRegister(registerC) : 0;
        this.registerD = (registerCount > 1) ? Preconditions.checkNibbleRegister(registerD) : 0;
        this.registerE = (registerCount > 2) ? Preconditions.checkNibbleRegister(registerE) : 0;
        this.registerF = (registerCount > 3) ? Preconditions.checkNibbleRegister(registerF) : 0;
        this.registerG = (registerCount > 4) ? Preconditions.checkNibbleRegister(registerG) : 0;
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction35c of(Instruction35c instruction) {
        if (instruction instanceof ImmutableInstruction35c) {
            return (ImmutableInstruction35c) instruction;
        }
        return new ImmutableInstruction35c(
                instruction.getOpcode(),
                instruction.getRegisterCount(),
                instruction.getRegisterC(),
                instruction.getRegisterD(),
                instruction.getRegisterE(),
                instruction.getRegisterF(),
                instruction.getRegisterG(),
                instruction.getReference());
    }

    @Override
    public int getRegisterCount() {
        return registerCount;
    }

    @Override
    public int getRegisterC() {
        return registerC;
    }

    @Override
    public int getRegisterD() {
        return registerD;
    }

    @Override
    public int getRegisterE() {
        return registerE;
    }

    @Override
    public int getRegisterF() {
        return registerF;
    }

    @Override
    public int getRegisterG() {
        return registerG;
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
