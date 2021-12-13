package org.jf.smali;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;

public class SmaliCatchParser extends smaliParser {
    public SmaliCatchParser(TokenStream input) {
        super(input);
    }

    public SmaliCatchParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    private RecognitionException firstException = null;

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
