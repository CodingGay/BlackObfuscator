package org.jf.smali;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.tree.TreeNodeStream;

public class SmaliCatchTreeWalker extends smaliTreeWalker {

    private RecognitionException firstException = null;

    public SmaliCatchTreeWalker(TreeNodeStream input) {
        super(input);
    }

    public SmaliCatchTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        String hdr = this.getErrorHeader(e);
        String msg = this.getErrorMessage(e, tokenNames);
        String errMsg = hdr + " " + msg;
        this.emitErrorMessage(errMsg);
        if (firstException == null) {
            firstException = new MsgRecognitionException(e, errMsg);
        }
    }

    public RecognitionException getFirstException() {
        return firstException;
    }
}
