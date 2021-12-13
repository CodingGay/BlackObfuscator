

package org.jf.dexlib2.immutable.instruction;



import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rms;
import org.jf.dexlib2.util.Preconditions;

public class ImmutableInstruction3rms extends ImmutableInstruction implements Instruction3rms {
    public static final Format FORMAT = Format.Format3rms;

    protected final int startRegister;
    protected final int registerCount;
    protected final int vtableIndex;

    public ImmutableInstruction3rms(Opcode opcode,
                                    int startRegister,
                                    int registerCount,
                                    int vtableIndex) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(startRegister);
        this.registerCount = Preconditions.checkRegisterRangeCount(registerCount);
        this.vtableIndex = Preconditions.checkVtableIndex(vtableIndex);
    }

    public static ImmutableInstruction3rms of(Instruction3rms instruction) {
        if (instruction instanceof ImmutableInstruction3rms) {
            return (ImmutableInstruction3rms) instruction;
        }
        return new ImmutableInstruction3rms(
                instruction.getOpcode(),
                instruction.getStartRegister(),
                instruction.getRegisterCount(),
                instruction.getVtableIndex());
    }

    @Override
    public int getStartRegister() {
        return startRegister;
    }

    @Override
    public int getRegisterCount() {
        return registerCount;
    }

    @Override
    public int getVtableIndex() {
        return vtableIndex;
    }

    @Override
    public Format getFormat() {
        return FORMAT;
    }
}

