

package org.jf.dexlib2.immutable.instruction;



import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.instruction.formats.ArrayPayload;
import org.jf.dexlib2.iface.instruction.formats.Instruction10t;
import org.jf.dexlib2.iface.instruction.formats.Instruction10x;
import org.jf.dexlib2.iface.instruction.formats.Instruction11n;
import org.jf.dexlib2.iface.instruction.formats.Instruction11x;
import org.jf.dexlib2.iface.instruction.formats.Instruction12x;
import org.jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.jf.dexlib2.iface.instruction.formats.Instruction20t;
import org.jf.dexlib2.iface.instruction.formats.Instruction21c;
import org.jf.dexlib2.iface.instruction.formats.Instruction21ih;
import org.jf.dexlib2.iface.instruction.formats.Instruction21lh;
import org.jf.dexlib2.iface.instruction.formats.Instruction21s;
import org.jf.dexlib2.iface.instruction.formats.Instruction21t;
import org.jf.dexlib2.iface.instruction.formats.Instruction22b;
import org.jf.dexlib2.iface.instruction.formats.Instruction22c;
import org.jf.dexlib2.iface.instruction.formats.Instruction22cs;
import org.jf.dexlib2.iface.instruction.formats.Instruction22s;
import org.jf.dexlib2.iface.instruction.formats.Instruction22t;
import org.jf.dexlib2.iface.instruction.formats.Instruction22x;
import org.jf.dexlib2.iface.instruction.formats.Instruction23x;
import org.jf.dexlib2.iface.instruction.formats.Instruction30t;
import org.jf.dexlib2.iface.instruction.formats.Instruction31c;
import org.jf.dexlib2.iface.instruction.formats.Instruction31i;
import org.jf.dexlib2.iface.instruction.formats.Instruction31t;
import org.jf.dexlib2.iface.instruction.formats.Instruction32x;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.instruction.formats.Instruction35mi;
import org.jf.dexlib2.iface.instruction.formats.Instruction35ms;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rc;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rmi;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rms;
import org.jf.dexlib2.iface.instruction.formats.Instruction51l;
import org.jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;
import org.jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;
import org.jf.dexlib2.iface.instruction.formats.UnknownInstruction;
import org.jf.dexlib2.util.Preconditions;
import org.jf.util.ImmutableConverter;

public abstract class ImmutableInstruction implements Instruction {

    protected final Opcode opcode;

    protected ImmutableInstruction(Opcode opcode) {
        Preconditions.checkFormat(opcode, getFormat());
        this.opcode = opcode;
    }


    public static ImmutableInstruction of(Instruction instruction) {
        if (instruction instanceof ImmutableInstruction) {
            return (ImmutableInstruction) instruction;
        }

        switch (instruction.getOpcode().format) {
            case Format10t:
                return ImmutableInstruction10t.of((Instruction10t) instruction);
            case Format10x:
                if (instruction instanceof UnknownInstruction) {
                    return ImmutableUnknownInstruction.of((UnknownInstruction) instruction);
                }
                return ImmutableInstruction10x.of((Instruction10x) instruction);
            case Format11n:
                return ImmutableInstruction11n.of((Instruction11n) instruction);
            case Format11x:
                return ImmutableInstruction11x.of((Instruction11x) instruction);
            case Format12x:
                return ImmutableInstruction12x.of((Instruction12x) instruction);
            case Format20bc:
                return ImmutableInstruction20bc.of((Instruction20bc) instruction);
            case Format20t:
                return ImmutableInstruction20t.of((Instruction20t) instruction);
            case Format21c:
                return ImmutableInstruction21c.of((Instruction21c) instruction);
            case Format21ih:
                return ImmutableInstruction21ih.of((Instruction21ih) instruction);
            case Format21lh:
                return ImmutableInstruction21lh.of((Instruction21lh) instruction);
            case Format21s:
                return ImmutableInstruction21s.of((Instruction21s) instruction);
            case Format21t:
                return ImmutableInstruction21t.of((Instruction21t) instruction);
            case Format22b:
                return ImmutableInstruction22b.of((Instruction22b) instruction);
            case Format22c:
                return ImmutableInstruction22c.of((Instruction22c) instruction);
            case Format22cs:
                return ImmutableInstruction22cs.of((Instruction22cs) instruction);
            case Format22s:
                return ImmutableInstruction22s.of((Instruction22s) instruction);
            case Format22t:
                return ImmutableInstruction22t.of((Instruction22t) instruction);
            case Format22x:
                return ImmutableInstruction22x.of((Instruction22x) instruction);
            case Format23x:
                return ImmutableInstruction23x.of((Instruction23x) instruction);
            case Format30t:
                return ImmutableInstruction30t.of((Instruction30t) instruction);
            case Format31c:
                return ImmutableInstruction31c.of((Instruction31c) instruction);
            case Format31i:
                return ImmutableInstruction31i.of((Instruction31i) instruction);
            case Format31t:
                return ImmutableInstruction31t.of((Instruction31t) instruction);
            case Format32x:
                return ImmutableInstruction32x.of((Instruction32x) instruction);
            case Format35c:
                return ImmutableInstruction35c.of((Instruction35c) instruction);
            case Format35mi:
                return ImmutableInstruction35mi.of((Instruction35mi) instruction);
            case Format35ms:
                return ImmutableInstruction35ms.of((Instruction35ms) instruction);
            case Format3rc:
                return ImmutableInstruction3rc.of((Instruction3rc) instruction);
            case Format3rmi:
                return ImmutableInstruction3rmi.of((Instruction3rmi) instruction);
            case Format3rms:
                return ImmutableInstruction3rms.of((Instruction3rms) instruction);
            case Format51l:
                return ImmutableInstruction51l.of((Instruction51l) instruction);
            case PackedSwitchPayload:
                return ImmutablePackedSwitchPayload.of((PackedSwitchPayload) instruction);
            case SparseSwitchPayload:
                return ImmutableSparseSwitchPayload.of((SparseSwitchPayload) instruction);
            case ArrayPayload:
                return ImmutableArrayPayload.of((ArrayPayload) instruction);
            default:
                throw new RuntimeException("Unexpected instruction type");
        }
    }


    public Opcode getOpcode() {
        return opcode;
    }

    public abstract Format getFormat();

    public int getCodeUnits() {
        return getFormat().size / 2;
    }


    public static ImmutableList<ImmutableInstruction> immutableListOf(Iterable<? extends Instruction> list) {
        return CONVERTER.toList(list);
    }

    private static final ImmutableConverter<ImmutableInstruction, Instruction> CONVERTER =
            new ImmutableConverter<ImmutableInstruction, Instruction>() {
                @Override
                protected boolean isImmutable(Instruction item) {
                    return item instanceof ImmutableInstruction;
                }


                @Override
                protected ImmutableInstruction makeImmutable(Instruction item) {
                    return ImmutableInstruction.of(item);
                }
            };
}
