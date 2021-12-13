

package org.jf.dexlib2.immutable;




import com.google.common.collect.ImmutableList;

import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.immutable.debug.ImmutableDebugItem;
import org.jf.dexlib2.immutable.instruction.ImmutableInstruction;
import org.jf.util.ImmutableUtils;

import java.util.List;

public class ImmutableMethodImplementation implements MethodImplementation {
    protected final int registerCount;

    protected final ImmutableList<? extends ImmutableInstruction> instructions;

    protected final ImmutableList<? extends ImmutableTryBlock> tryBlocks;

    protected final ImmutableList<? extends ImmutableDebugItem> debugItems;

    public ImmutableMethodImplementation(int registerCount,
                                         Iterable<? extends Instruction> instructions,
                                         List<? extends TryBlock<? extends ExceptionHandler>> tryBlocks,
                                         Iterable<? extends DebugItem> debugItems) {
        this.registerCount = registerCount;
        this.instructions = ImmutableInstruction.immutableListOf(instructions);
        this.tryBlocks = ImmutableTryBlock.immutableListOf(tryBlocks);
        this.debugItems = ImmutableDebugItem.immutableListOf(debugItems);
    }

    public ImmutableMethodImplementation(int registerCount,
                                         ImmutableList<? extends ImmutableInstruction> instructions,
                                         ImmutableList<? extends ImmutableTryBlock> tryBlocks,
                                         ImmutableList<? extends ImmutableDebugItem> debugItems) {
        this.registerCount = registerCount;
        this.instructions = ImmutableUtils.nullToEmptyList(instructions);
        this.tryBlocks = ImmutableUtils.nullToEmptyList(tryBlocks);
        this.debugItems = ImmutableUtils.nullToEmptyList(debugItems);
    }


    public static ImmutableMethodImplementation of(MethodImplementation methodImplementation) {
        if (methodImplementation == null) {
            return null;
        }
        if (methodImplementation instanceof ImmutableMethodImplementation) {
            return (ImmutableMethodImplementation) methodImplementation;
        }
        return new ImmutableMethodImplementation(
                methodImplementation.getRegisterCount(),
                methodImplementation.getInstructions(),
                methodImplementation.getTryBlocks(),
                methodImplementation.getDebugItems());
    }

    @Override
    public int getRegisterCount() {
        return registerCount;
    }


    @Override
    public ImmutableList<? extends ImmutableInstruction> getInstructions() {
        return instructions;
    }


    @Override
    public ImmutableList<? extends ImmutableTryBlock> getTryBlocks() {
        return tryBlocks;
    }


    @Override
    public ImmutableList<? extends ImmutableDebugItem> getDebugItems() {
        return debugItems;
    }
}
