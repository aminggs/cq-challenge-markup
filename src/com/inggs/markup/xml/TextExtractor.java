package com.inggs.markup.xml;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.Writer;

/**
 * From <a href="http://www.cafeconleche.org/books/xmljava/chapters/ch06s03.html">.
 */
public class TextExtractor implements ContentHandler {

    private Writer out;

    public TextExtractor(Writer out) {
        this.out = out;
    }

    public void characters(char[] text, int start, int length)
            throws SAXException {

        try {
            out.write(text, start, length);
        }
        catch (IOException e) {
            throw new SAXException(e);
        }

    }

    // do-nothing methods

    public void setDocumentLocator(Locator locator) {
    }

    public void startDocument() {
    }

    public void endDocument() {
    }

    public void startPrefixMapping(String prefix, String uri) {
    }

    public void endPrefixMapping(String prefix) {
    }

    public void startElement(String namespaceURI, String localName,
                             String qualifiedName, Attributes atts) {
    }

    public void endElement(String namespaceURI, String localName,
                           String qualifiedName) {
    }

    public void ignorableWhitespace(char[] text, int start,
                                    int length) throws SAXException {
    }

    public void processingInstruction(String target, String data) {
    }

    public void skippedEntity(String name) {
    }

} // end TextExtractor
