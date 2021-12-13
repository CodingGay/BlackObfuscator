

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction21lh;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction21lh extends ImmutableInstruction implements Instruction21lh {
    public static final Format FORMAT = Format.Format21lh;

    protected final int registerA;
    protected final long literal;

    public ImmutableInstruction21lh(Opcode opcode,
                                    int registerA,
                                    long literal) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(registerA);
        this.literal = Preconditions.checkLongHatLiteral(literal);
    }

    public static ImmutableInstruction21lh of(Instruction21lh instruction) {
        if (instruction instanceof ImmutableInstruction21lh) {
            return (ImmutableInstruction21lh) instruction;
        }
        return new ImmutableInstruction21lh(
                instruction.getOpcode(),
                instruction.getRegisterA(),
                instruction.getWideLiteral());
    }

    @Override
    public int getRegisterA() {
        return registerA;
    }

    @Override
    public long getWideLiteral() {
        return literal;
    }

    @Override
    public short getHatLiteral() {
        return (short) (literal >>> 48);
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}
