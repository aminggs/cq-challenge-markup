package com.inggs.markup.parser;

/**
 * @author Andrew Inggs
 */
class MarkupToken {

    static enum Type {

        INDENT, TAG, CHAR, EOL, EOF

    }

    static final MarkupToken EOL = new MarkupToken(Type.EOL, null);

    static final MarkupToken EOF = new MarkupToken(Type.EOF, null);

    MarkupToken(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    Type type;

    String value;

}
