

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22t;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction22t extends ImmutableInstruction implements Instruction22t {
    public static final Format FORMAT = Format.Format22t;

    protected final int registerA;
    protected final int registerB;
    protected final int codeOffset;

    public ImmutableInstruction22t(Opcode opcode,
                                   int registerA,
                                   int registerB,
                                   int codeOffset) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(registerA);
        this.registerB = Preconditions.checkNibbleRegister(registerB);
        this.codeOffset = Preconditions.checkShortCodeOffset(codeOffset);
    }

    public static ImmutableInstruction22t of(Instruction22t instruction) {
        if (instruction instanceof ImmutableInstruction22t) {
            return (ImmutableInstruction22t) instruction;
        }
        return new ImmutableInstruction22t(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getRegisterB(),
                instruction.getCodeOffset());
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
    public int getCodeOffset() {
        return codeOffset;
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
