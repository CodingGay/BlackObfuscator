

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22s;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction22s extends ImmutableInstruction implements Instruction22s {
    public static final Format FORMAT = Format.Format22s;

    protected final int registerA;
    protected final int registerB;
    protected final int literal;

    public ImmutableInstruction22s(Opcode opcode,
                                   int registerA,
                                   int registerB,
                                   int literal) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(registerA);
        this.registerB = Preconditions.checkNibbleRegister(registerB);
        this.literal = Preconditions.checkShortLiteral(literal);
    }

    public static ImmutableInstruction22s of(Instruction22s instruction) {
        if (instruction instanceof ImmutableInstruction22s) {
            return (ImmutableInstruction22s) instruction;
        }
        return new ImmutableInstruction22s(
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