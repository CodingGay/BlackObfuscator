

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction30t;

public class ImmutableInstruction30t extends ImmutableInstruction implements Instruction30t {
    public static final Format FORMAT = Format.Format30t;

    protected final int codeOffset;

    public ImmutableInstruction30t(Opcode opcode,
                                   int codeOffset) {
        super(opcode);
        this.codeOffset = codeOffset;
    }

    public static ImmutableInstruction30t of(Instruction30t instruction) {
        if (instruction instanceof ImmutableInstruction30t) {
            return (ImmutableInstruction30t) instruction;
        }
        return new ImmutableInstruction30t(
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

