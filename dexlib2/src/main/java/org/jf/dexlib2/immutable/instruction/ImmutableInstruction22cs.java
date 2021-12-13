

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22cs;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction22cs extends ImmutableInstruction implements Instruction22cs {
    public static final Format FORMAT = Format.Format22cs;

    protected final int registerA;
    protected final int registerB;
    protected final int fieldOffset;

    public ImmutableInstruction22cs(Opcode opcode,
                                    int registerA,
                                    int registerB,
                                    int fieldOffset) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(registerA);
        this.registerB = Preconditions.checkNibbleRegister(registerB);
        this.fieldOffset = Preconditions.checkFieldOffset(fieldOffset);
    }

    public static ImmutableInstruction22cs of(Instruction22cs instruction) {
        if (instruction instanceof ImmutableInstruction22cs) {
            return (ImmutableInstruction22cs) instruction;
        }
        return new ImmutableInstruction22cs(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getRegisterB(),
                instruction.getFieldOffset());
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
    public int getFieldOffset() {
        return fieldOffset;
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
