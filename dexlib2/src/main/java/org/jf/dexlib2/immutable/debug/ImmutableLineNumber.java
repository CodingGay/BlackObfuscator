

package org.jf.dexlib2.immutable.debug;



import org.jf.dexlib2.DebugItemType;
import org.jf.dexlib2.iface.debug.LineNumber;

public class ImmutableLineNumber extends ImmutableDebugItem implements LineNumber {
    protected final int lineNumber;

    public ImmutableLineNumber(int codeAddress,
                               int lineNumber) {
        super(codeAddress);
        this.lineNumber = lineNumber;
    }

    
    public static ImmutableLineNumber of(LineNumber lineNumber) {
        if (lineNumber instanceof ImmutableLineNumber) {
            return (ImmutableLineNumber) lineNumber;
        }
        return new ImmutableLineNumber(
                lineNumber.getCodeAddress(),
                lineNumber.getLineNumber());
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public int getDebugItemType() {
        return DebugItemType.LINE_NUMBER;
    }
}
