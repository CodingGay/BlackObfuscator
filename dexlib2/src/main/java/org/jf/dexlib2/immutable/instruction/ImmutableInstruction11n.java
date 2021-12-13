

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction11n;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction11n extends ImmutableInstruction implements Instruction11n {
    public static final Format FORMAT = Format.Format11n;

    protected final int registerA;
    protected final int literal;

    public ImmutableInstruction11n(Opcode opcode,
                                   int registerA,
                                   int literal) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(registerA);
        this.literal = Preconditions.checkNibbleLiteral(literal);
    }

    public static ImmutableInstruction11n of(Instruction11n instruction) {
        if (instruction instanceof ImmutableInstruction11n) {
            return (ImmutableInstruction11n) instruction;
        }
        return new ImmutableInstruction11n(
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
