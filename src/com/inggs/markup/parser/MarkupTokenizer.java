package com.inggs.markup.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.UnsupportedEncodingException;

/**
 * @author Andrew Inggs
 */
class MarkupTokenizer {

    /**
     * Used to indicate whether the tokenizer interprets a backslash (\) as an
     * escape character (NORMAL), or passes it through unmodified (VERBATUM).
     */
    static enum State {

        NORMAL, VERBATIUM

    }

    private State state = State.NORMAL;

    private PushbackReader pushbackReader;

    private MarkupToken currentToken;

    public MarkupTokenizer(InputStream inputStream) throws IOException {
        try {
            this.pushbackReader = new PushbackReader(new InputStreamReader(inputStream, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        currentToken = nextToken();
    }

    public MarkupToken currentToken() {
        return currentToken;
    }

    public MarkupToken nextToken() throws IOException {
        int ch = pushbackReader.read();
        switch (ch) {
            case -1:
                return MarkupToken.EOF;
            default:
                return new MarkupToken(MarkupToken.Type.CHAR, Character.toString((char) ch));
        }
    }

}
