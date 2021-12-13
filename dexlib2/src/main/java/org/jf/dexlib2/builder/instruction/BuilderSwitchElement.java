package org.jf.dexlib2.builder.instruction;



import org.jf.dexlib2.builder.BuilderSwitchPayload;
import org.jf.dexlib2.builder.Label;
import org.jf.dexlib2.iface.instruction.SwitchElement;

public class BuilderSwitchElement implements SwitchElement {

    BuilderSwitchPayload parent;
    private final int key;

    private final Label target;

    public BuilderSwitchElement(BuilderSwitchPayload parent,
                                int key,
                                Label target) {
        this.parent = parent;
        this.key = key;
        this.target = target;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public int getOffset() {
        return target.getCodeAddress() - parent.getReferrer().getCodeAddress();
    }


    public Label getTarget() {
        return target;
    }
}
