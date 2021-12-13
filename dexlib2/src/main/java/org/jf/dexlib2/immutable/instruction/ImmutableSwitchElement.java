

package org.jf.dexlib2.immutable.instruction;




import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.util.ImmutableConverter;

import java.util.List;

public class ImmutableSwitchElement implements SwitchElement {
    protected final int key;
    protected final int offset;

    public ImmutableSwitchElement(int key,
                                  int offset) {
        this.key = key;
        this.offset = offset;
    }


    public static ImmutableSwitchElement of(SwitchElement switchElement) {
        if (switchElement instanceof ImmutableSwitchElement) {
            return (ImmutableSwitchElement) switchElement;
        }
        return new ImmutableSwitchElement(
                switchElement.getKey(),
                switchElement.getOffset());
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public int getOffset() {
        return offset;
    }


    public static ImmutableList<ImmutableSwitchElement> immutableListOf(List<? extends SwitchElement> list) {
        return CONVERTER.toList(list);
    }

    private static final ImmutableConverter<ImmutableSwitchElement, SwitchElement> CONVERTER =
            new ImmutableConverter<ImmutableSwitchElement, SwitchElement>() {
                @Override
                protected boolean isImmutable(SwitchElement item) {
                    return item instanceof ImmutableSwitchElement;
                }


                @Override
                protected ImmutableSwitchElement makeImmutable(SwitchElement item) {
                    return ImmutableSwitchElement.of(item);
                }
            };
}
