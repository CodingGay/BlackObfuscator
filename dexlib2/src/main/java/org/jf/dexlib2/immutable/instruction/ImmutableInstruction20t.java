

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction20t;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction20t extends ImmutableInstruction implements Instruction20t {
    public static final Format FORMAT = Format.Format20t;

    protected final int codeOffset;

    public ImmutableInstruction20t(Opcode opcode,
                                   int codeOffset) {
        super(opcode);
        this.codeOffset = Preconditions.checkShortCodeOffset(codeOffset);
    }

    public static ImmutableInstruction20t of(Instruction20t instruction) {
        if (instruction instanceof ImmutableInstruction20t) {
            return (ImmutableInstruction20t) instruction;
        }
        return new ImmutableInstruction20t(
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
