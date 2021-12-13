package org.jf.smali;

import org.antlr.runtime.RecognitionException;

public class MsgRecognitionException extends RecognitionException {
    private final String msg;

    public MsgRecognitionException(RecognitionException e, String msg) {
        this.msg = msg;
        this.line = e.line;
        this.charPositionInLine = e.charPositionInLine;
    }

    public MsgRecognitionException(int line, int charPositionInLine, String msg) {
        this.msg = msg;
        this.line = line;
        this.charPositionInLine = charPositionInLine;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
