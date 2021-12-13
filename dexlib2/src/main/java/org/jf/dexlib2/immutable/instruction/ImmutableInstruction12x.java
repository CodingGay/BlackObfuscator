

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction12x;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction12x extends ImmutableInstruction implements Instruction12x {
    public static final Format FORMAT = Format.Format12x;

    protected final int registerA;
    protected final int registerB;

    public ImmutableInstruction12x(Opcode opcode,
                                   int registerA,
                                   int registerB) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(registerA);
        this.registerB = Preconditions.checkNibbleRegister(registerB);
    }

    public static ImmutableInstruction12x of(Instruction12x instruction) {
        if (instruction instanceof ImmutableInstruction12x) {
            return (ImmutableInstruction12x) instruction;
        }
        return new ImmutableInstruction12x(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getRegisterB());
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
    public Format getFormat() {
        return FORMAT;
    }
}
