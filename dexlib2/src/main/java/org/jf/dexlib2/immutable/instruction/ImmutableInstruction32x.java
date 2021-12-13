

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction32x;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction32x extends ImmutableInstruction implements Instruction32x {
    public static final Format FORMAT = Format.Format32x;

    protected final int registerA;
    protected final int registerB;

    public ImmutableInstruction32x(Opcode opcode,
                                   int registerA,
                                   int registerB) {
        super(opcode);
        this.registerA = Preconditions.checkShortRegister(registerA);
        this.registerB = Preconditions.checkShortRegister(registerB);
    }

    public static ImmutableInstruction32x of(Instruction32x instruction) {
        if (instruction instanceof ImmutableInstruction32x) {
            return (ImmutableInstruction32x) instruction;
        }
        return new ImmutableInstruction32x(
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
