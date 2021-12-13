

package org.jf.dexlib2.immutable.instruction;




import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;
import org.jf.util.ImmutableUtils;

import java.util.List;

public class ImmutablePackedSwitchPayload extends ImmutableInstruction implements PackedSwitchPayload {
    public static final Opcode OPCODE = Opcode.PACKED_SWITCH_PAYLOAD;


    protected final ImmutableList<? extends ImmutableSwitchElement> switchElements;

    public ImmutablePackedSwitchPayload(List<? extends SwitchElement> switchElements) {
        super(OPCODE);
        //TODO: need to validate that the keys are sequential
        this.switchElements = ImmutableSwitchElement.immutableListOf(switchElements);
    }

    public ImmutablePackedSwitchPayload(
            ImmutableList<? extends ImmutableSwitchElement> switchElements) {
        super(OPCODE);
        this.switchElements = ImmutableUtils.nullToEmptyList(switchElements);
    }


    public static ImmutablePackedSwitchPayload of(PackedSwitchPayload instruction) {
        if (instruction instanceof ImmutablePackedSwitchPayload) {
            return (ImmutablePackedSwitchPayload) instruction;
        }
        return new ImmutablePackedSwitchPayload(
                instruction.getSwitchElements());
    }


    @Override
    public List<? extends SwitchElement> getSwitchElements() {
        return switchElements;
    }

    @Override
    public int getCodeUnits() {
        return 4 + switchElements.size() * 2;
    }

    @Override
    public Format getFormat() {
        return OPCODE.format;
    }
}
