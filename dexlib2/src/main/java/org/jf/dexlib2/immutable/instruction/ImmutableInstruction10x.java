

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction10x;

public class ImmutableInstruction10x extends ImmutableInstruction implements Instruction10x {
    public static final Format FORMAT = Format.Format10x;

    public ImmutableInstruction10x(Opcode opcode) {
        super(opcode);
    }

    public static ImmutableInstruction10x of(Instruction10x instruction) {
        if (instruction instanceof ImmutableInstruction10x) {
            return (ImmutableInstruction10x) instruction;
        }
        return new ImmutableInstruction10x(instruction.getOpcode());
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
