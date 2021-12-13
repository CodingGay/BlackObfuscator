

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction10t;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction10t extends ImmutableInstruction implements Instruction10t {
    public static final Format FORMAT = Format.Format10t;

    protected final int codeOffset;

    public ImmutableInstruction10t(Opcode opcode,
                                   int codeOffset) {
        super(opcode);
        this.codeOffset = Preconditions.checkByteCodeOffset(codeOffset);
    }

    public static ImmutableInstruction10t of(Instruction10t instruction) {
        if (instruction instanceof ImmutableInstruction10t) {
            return (ImmutableInstruction10t) instruction;
        }
        return new ImmutableInstruction10t(
                instruction.getOpcode(),
                instruction.getCodeOffset());
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
