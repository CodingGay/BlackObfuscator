

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction23x;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction23x extends ImmutableInstruction implements Instruction23x {
    public static final Format FORMAT = Format.Format23x;

    protected final int registerA;
    protected final int registerB;
    protected final int registerC;

    public ImmutableInstruction23x(Opcode opcode,
                                   int registerA,
                                   int registerB,
                                   int registerC) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(registerA);
        this.registerB = Preconditions.checkByteRegister(registerB);
        this.registerC = Preconditions.checkByteRegister(registerC);
    }

    public static ImmutableInstruction23x of(Instruction23x instruction) {
        if (instruction instanceof ImmutableInstruction23x) {
            return (ImmutableInstruction23x) instruction;
        }
        return new ImmutableInstruction23x(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getRegisterB(),
                instruction.getRegisterC());
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
    public int getRegisterC() {
        return registerC;
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
