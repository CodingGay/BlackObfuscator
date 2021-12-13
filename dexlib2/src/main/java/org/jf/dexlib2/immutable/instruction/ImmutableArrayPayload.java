

package org.jf.dexlib2.immutable.instruction;




import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.ArrayPayload;
import org.jf.util.ImmutableUtils;

import java.util.List;

public class ImmutableArrayPayload extends ImmutableInstruction implements ArrayPayload {
    public static final Opcode OPCODE = Opcode.ARRAY_PAYLOAD;

    protected final int elementWidth;
    
    protected final ImmutableList<Number> arrayElements;

    public ImmutableArrayPayload(int elementWidth,
                                 List<Number> arrayElements) {
        super(OPCODE);
        this.elementWidth = elementWidth;
        this.arrayElements = arrayElements == null ? ImmutableList.<Number>of() : ImmutableList.copyOf(arrayElements);
    }

    public ImmutableArrayPayload(int elementWidth,
                                 ImmutableList<Number> arrayElements) {
        super(OPCODE);
        //TODO: need to ensure this is a valid width (1, 2, 4, 8)
        this.elementWidth = elementWidth;
        //TODO: need to validate the elements fit within the width
        this.arrayElements = ImmutableUtils.nullToEmptyList(arrayElements);
    }

    
    public static ImmutableArrayPayload of(ArrayPayload instruction) {
        if (instruction instanceof ImmutableArrayPayload) {
            return (ImmutableArrayPayload) instruction;
        }
        return new ImmutableArrayPayload(
                instruction.getElementWidth(),
                instruction.getArrayElements());
    }

    @Override
    public int getElementWidth() {
        return elementWidth;
    }

    
    @Override
    public List<Number> getArrayElements() {
        return arrayElements;
    }

    @Override
    public int getCodeUnits() {
        return 4 + (elementWidth * arrayElements.size() + 1) / 2;
    }

    @Override
    public Format getFormat() {
        return OPCODE.format;
    }
}
