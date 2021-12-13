

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction31i;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction31i extends ImmutableInstruction implements Instruction31i {
    public static final Format FORMAT = Format.Format31i;

    protected final int registerA;
    protected final int literal;

    public ImmutableInstruction31i(Opcode opcode,
                                   int registerA,
                                   int literal) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(registerA);
        this.literal = literal;
    }

    public static ImmutableInstruction31i of(Instruction31i instruction) {
        if (instruction instanceof ImmutableInstruction31i) {
            return (ImmutableInstruction31i) instruction;
        }
        return new ImmutableInstruction31i(
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
