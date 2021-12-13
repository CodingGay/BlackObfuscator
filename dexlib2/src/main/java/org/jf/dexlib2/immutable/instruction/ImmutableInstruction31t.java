

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction31t;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction31t extends ImmutableInstruction implements Instruction31t {
    public static final Format FORMAT = Format.Format31t;

    protected final int registerA;
    protected final int codeOffset;

    public ImmutableInstruction31t(Opcode opcode,
                                   int registerA,
                                   int codeOffset) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(registerA);
        this.codeOffset = codeOffset;
    }

    public static ImmutableInstruction31t of(Instruction31t instruction) {
        if (instruction instanceof ImmutableInstruction31t) {
            return (ImmutableInstruction31t) instruction;
        }
        return new ImmutableInstruction31t(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getCodeOffset());
    }

    @Override
    public int getRegisterA() {
        return registerA;
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

