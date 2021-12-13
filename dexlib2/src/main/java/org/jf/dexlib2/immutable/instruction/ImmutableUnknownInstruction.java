

package org.jf.dexlib2.immutable.instruction;

import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.UnknownInstruction;

public class ImmutableUnknownInstruction extends ImmutableInstruction implements UnknownInstruction {
    public static final Format FORMAT = Format.Format10x;

    protected final int originalOpcode;

    public ImmutableUnknownInstruction(int originalOpcode) {
        super(Opcode.NOP);
        this.originalOpcode = originalOpcode;
    }

    public static ImmutableUnknownInstruction of(UnknownInstruction instruction) {
        if (instruction instanceof ImmutableUnknownInstruction) {
            return (ImmutableUnknownInstruction) instruction;
        }
        return new ImmutableUnknownInstruction(instruction.getOriginalOpcode());
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }

    @Override
    public int getOriginalOpcode() {
        return originalOpcode;
    }
}
