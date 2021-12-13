

package org.jf.dexlib2.immutable;




import com.google.common.collect.ImmutableSet;

import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.DexFile;
import org.jf.util.ImmutableUtils;

import java.util.Collection;

public class ImmutableDexFile implements DexFile {
    
    protected final ImmutableSet<? extends ImmutableClassDef> classes;
    
    private final Opcodes opcodes;

    public ImmutableDexFile(Opcodes opcodes, Collection<? extends ClassDef> classes) {
        this.classes = ImmutableClassDef.immutableSetOf(classes);
        this.opcodes = opcodes;
    }

    public ImmutableDexFile(Opcodes opcodes, ImmutableSet<? extends ImmutableClassDef> classes) {
        this.classes = ImmutableUtils.nullToEmptySet(classes);
        this.opcodes = opcodes;
    }

    public static ImmutableDexFile of(DexFile dexFile) {
        if (dexFile instanceof ImmutableDexFile) {
            return (ImmutableDexFile) dexFile;
        }
        return new ImmutableDexFile(dexFile.getOpcodes(), dexFile.getClasses());
    }

    
    @Override
    public ImmutableSet<? extends ImmutableClassDef> getClasses() {
        return classes;
    }

    
    @Override
    public Opcodes getOpcodes() {
        return opcodes;
    }
}
