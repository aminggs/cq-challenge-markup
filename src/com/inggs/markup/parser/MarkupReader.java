package com.inggs.markup.parser;

import org.xml.sax.ContentHandler;

import java.io.InputStream;

/**
 * @author Andrew Inggs
 */
public class MarkupReader {

    private InputStream inputStream;

    private ContentHandler contentHandler;

    // setters and getters

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    // constructors

    public MarkupReader() {
    }

    public MarkupReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public MarkupReader(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    public MarkupReader(InputStream inputStream, ContentHandler contentHandler) {
        this.inputStream = inputStream;
        this.contentHandler = contentHandler;
    }

    // ordinary methods

    public void parse() {

    }

}
