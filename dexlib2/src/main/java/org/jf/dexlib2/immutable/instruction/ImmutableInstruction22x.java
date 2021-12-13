

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22x;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction22x extends ImmutableInstruction implements Instruction22x {
    public static final Format FORMAT = Format.Format22x;

    protected final int registerA;
    protected final int registerB;

    public ImmutableInstruction22x(Opcode opcode,
                                   int registerA,
                                   int registerB) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(registerA);
        this.registerB = Preconditions.checkShortRegister(registerB);
    }

    public static ImmutableInstruction22x of(Instruction22x instruction) {
        if (instruction instanceof ImmutableInstruction22x) {
            return (ImmutableInstruction22x) instruction;
        }
        return new ImmutableInstruction22x(
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
