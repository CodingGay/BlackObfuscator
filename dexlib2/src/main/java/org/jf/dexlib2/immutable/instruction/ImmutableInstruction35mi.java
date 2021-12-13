

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction35mi;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction35mi extends ImmutableInstruction implements Instruction35mi {
    public static final Format FORMAT = Format.Format35mi;

    protected final int registerCount;
    protected final int registerC;
    protected final int registerD;
    protected final int registerE;
    protected final int registerF;
    protected final int registerG;
    protected final int inlineIndex;

    public ImmutableInstruction35mi(Opcode opcode,
                                    int registerCount,
                                    int registerC,
                                    int registerD,
                                    int registerE,
                                    int registerF,
                                    int registerG,
                                    int inlineIndex) {
        super(opcode);
        this.registerCount = Preconditions.check35cAnd45ccRegisterCount(registerCount);
        this.registerC = (registerCount > 0) ? Preconditions.checkNibbleRegister(registerC) : 0;
        this.registerD = (registerCount > 1) ? Preconditions.checkNibbleRegister(registerD) : 0;
        this.registerE = (registerCount > 2) ? Preconditions.checkNibbleRegister(registerE) : 0;
        this.registerF = (registerCount > 3) ? Preconditions.checkNibbleRegister(registerF) : 0;
        this.registerG = (registerCount > 4) ? Preconditions.checkNibbleRegister(registerG) : 0;
        this.inlineIndex = Preconditions.checkInlineIndex(inlineIndex);
    }

    public static ImmutableInstruction35mi of(Instruction35mi instruction) {
        if (instruction instanceof ImmutableInstruction35mi) {
            return (ImmutableInstruction35mi) instruction;
        }
        return new ImmutableInstruction35mi(
                instruction.getOpcode(),
                instruction.getRegisterCount(),
                instruction.getRegisterC(),
                instruction.getRegisterD(),
                instruction.getRegisterE(),
                instruction.getRegisterF(),
                instruction.getRegisterG(),
                instruction.getInlineIndex());
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
    public int getInlineIndex() {
        return inlineIndex;
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
