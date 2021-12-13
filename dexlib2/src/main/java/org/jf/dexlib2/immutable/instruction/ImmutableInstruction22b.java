

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22b;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction22b extends ImmutableInstruction implements Instruction22b {
    public static final Format FORMAT = Format.Format22b;

    protected final int registerA;
    protected final int registerB;
    protected final int literal;

    public ImmutableInstruction22b(Opcode opcode,
                                   int registerA,
                                   int registerB,
                                   int literal) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(registerA);
        this.registerB = Preconditions.checkByteRegister(registerB);
        this.literal = Preconditions.checkByteLiteral(literal);
    }

    public static ImmutableInstruction22b of(Instruction22b instruction) {
        if (instruction instanceof ImmutableInstruction22b) {
            return (ImmutableInstruction22b) instruction;
        }
        return new ImmutableInstruction22b(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getRegisterB(),
                instruction.getNarrowLiteral());
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
    public int getNarrowLiteral() {
        return literal;
    }

    @Override
    public long getWideLiteral() {
        return literal;
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
