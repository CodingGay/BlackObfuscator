

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction21s;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction21s extends ImmutableInstruction implements Instruction21s {
    public static final Format FORMAT = Format.Format21s;

    protected final int registerA;
    protected final int literal;

    public ImmutableInstruction21s(Opcode opcode,
                                   int registerA,
                                   int literal) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(registerA);
        this.literal = Preconditions.checkShortLiteral(literal);
    }

    public static ImmutableInstruction21s of(Instruction21s instruction) {
        if (instruction instanceof ImmutableInstruction21s) {
            return (ImmutableInstruction21s) instruction;
        }
        return new ImmutableInstruction21s(
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
    public Format getFormat() {
        return FORMAT;
    }
}
