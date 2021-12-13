

package org.jf.dexlib2.immutable.debug;




import org.jf.dexlib2.DebugItemType;
import org.jf.dexlib2.base.reference.BaseStringReference;
import org.jf.dexlib2.iface.UpdateReference;
import org.jf.dexlib2.iface.debug.SetSourceFile;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.writer.builder.DexBuilder;

public class ImmutableSetSourceFile extends ImmutableDebugItem implements SetSourceFile, UpdateReference {

    protected final String sourceFile;

    public ImmutableSetSourceFile(int codeAddress,
                                  String sourceFile) {
        super(codeAddress);
        this.sourceFile = sourceFile;
    }


    public static ImmutableSetSourceFile of(SetSourceFile setSourceFile) {
        if (setSourceFile instanceof ImmutableSetSourceFile) {
            return (ImmutableSetSourceFile) setSourceFile;
        }
        return new ImmutableSetSourceFile(
                setSourceFile.getCodeAddress(),
                setSourceFile.getSourceFile());
    }


    @Override
    public String getSourceFile() {
        return sourceFile;
    }


    @Override
    public StringReference getSourceFileReference() {
        if (sourceFileRef != null)
            return sourceFileRef;
        return sourceFile == null ? null : new BaseStringReference() {

            @Override
            public String getString() {
                return sourceFile;
            }
        };
    }


    @Override
    public int getDebugItemType() {
        return DebugItemType.SET_SOURCE_FILE;
    }


    private StringReference sourceFileRef;

    @Override
    public void updateReference(DexBuilder dexBuilder) {
        sourceFileRef = dexBuilder.internNullableStringReference(sourceFile);
    }
}
