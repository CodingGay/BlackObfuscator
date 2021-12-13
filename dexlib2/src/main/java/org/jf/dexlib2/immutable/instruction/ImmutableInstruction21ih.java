

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction21ih;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction21ih extends ImmutableInstruction implements Instruction21ih {
    public static final Format FORMAT = Format.Format21ih;

    protected final int registerA;
    protected final int literal;

    public ImmutableInstruction21ih(Opcode opcode,
                                    int registerA,
                                    int literal) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(registerA);
        this.literal = Preconditions.checkIntegerHatLiteral(literal);
    }

    public static ImmutableInstruction21ih of(Instruction21ih instruction) {
        if (instruction instanceof ImmutableInstruction21ih) {
            return (ImmutableInstruction21ih) instruction;
        }
        return new ImmutableInstruction21ih(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getNarrowLiteral());
    }

    @Override
    public int getRegisterA() {
        return registerA;
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
    public short getHatLiteral() {
        return (short) (literal >>> 16);
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
