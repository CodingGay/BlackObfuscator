

package org.jf.dexlib2.immutable.instruction;




import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;
import org.jf.util.ImmutableUtils;

import java.util.List;

public class ImmutableSparseSwitchPayload extends ImmutableInstruction implements SparseSwitchPayload {
    public static final Opcode OPCODE = Opcode.SPARSE_SWITCH_PAYLOAD;


    protected final ImmutableList<? extends ImmutableSwitchElement> switchElements;

    public ImmutableSparseSwitchPayload(List<? extends SwitchElement> switchElements) {
        super(OPCODE);
        this.switchElements = ImmutableSwitchElement.immutableListOf(switchElements);
    }

    public ImmutableSparseSwitchPayload(
            ImmutableList<? extends ImmutableSwitchElement> switchElements) {
        super(OPCODE);
        this.switchElements = ImmutableUtils.nullToEmptyList(switchElements);
    }


    public static ImmutableSparseSwitchPayload of(SparseSwitchPayload instruction) {
        if (instruction instanceof ImmutableSparseSwitchPayload) {
            return (ImmutableSparseSwitchPayload) instruction;
        }
        return new ImmutableSparseSwitchPayload(
                instruction.getSwitchElements());
    }


    @Override
    public List<? extends SwitchElement> getSwitchElements() {
        return switchElements;
    }

    @Override
    public int getCodeUnits() {
        return 2 + switchElements.size() * 4;
    }

    @Override
    public Format getFormat() {
        return OPCODE.format;
    }
}
