package com.inggs.markup.parser;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Andrew Inggs
 */
public class MarkupReader implements XMLReader {

    private static final String EMPTY_NAMESPACE_URI = "";

    private static final Attributes EMPTY_ATTRIBUTES = new EmptyAttributesImpl();

    private MarkupTokenizer tokenizer;

    private ContentHandler contentHandler;

    // constructors

    public MarkupReader() {
    }

    // XMLReader methods

    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new UnsupportedOperationException();
    }

    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        // do nothing
    }

    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        // do nothing
    }

    public void setEntityResolver(EntityResolver resolver) {
        throw new UnsupportedOperationException();
    }

    public EntityResolver getEntityResolver() {
        throw new UnsupportedOperationException();
    }

    public void setDTDHandler(DTDHandler handler) {
        throw new UnsupportedOperationException();
    }

    public DTDHandler getDTDHandler() {
        throw new UnsupportedOperationException();
    }

    public void setContentHandler(ContentHandler handler) {
        this.contentHandler = handler;
    }

    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    public void setErrorHandler(ErrorHandler handler) {
        throw new UnsupportedOperationException();
    }

    public ErrorHandler getErrorHandler() {
        throw new UnsupportedOperationException();
    }

    public void parse(InputSource input) throws IOException, SAXException {
        tokenizer = new MarkupTokenizer(input.getByteStream());
        contentHandler.startDocument();
        body();
        contentHandler.endDocument();
    }

    public void parse(String systemId) throws IOException, SAXException {
        throw new UnsupportedOperationException();
    }

    // parsing methods

    private void body() throws SAXException {
        emitStart("body");
        emitEnd("body");
    }

    // utility methods

    private void emitStart(String tagName) throws SAXException {
        contentHandler.startElement(EMPTY_NAMESPACE_URI, tagName, tagName, EMPTY_ATTRIBUTES);
    }

    private void emitEnd(String tagName) throws SAXException {
        contentHandler.endElement(EMPTY_NAMESPACE_URI, tagName, tagName);
    }
}

/**
 * This is a do-nothing helper class (implementing the SAX Attributes interface)
 * that throws UnsupportedOperationExceptions for all methods except {@link
 * #getLength()}, which returns 0 (zero).
 */
class EmptyAttributesImpl implements Attributes {

    public int getLength() {
        return 0;
    }

    public String getURI(int index) {
        throw new UnsupportedOperationException();
    }

    public String getLocalName(int index) {
        throw new UnsupportedOperationException();
    }

    public String getQName(int index) {
        throw new UnsupportedOperationException();
    }

    public String getType(int index) {
        throw new UnsupportedOperationException();
    }

    public String getValue(int index) {
        throw new UnsupportedOperationException();
    }

    public int getIndex(String uri, String localName) {
        throw new UnsupportedOperationException();
    }

    public int getIndex(String qName) {
        throw new UnsupportedOperationException();
    }

    public String getType(String uri, String localName) {
        throw new UnsupportedOperationException();
    }

    public String getType(String qName) {
        throw new UnsupportedOperationException();
    }

    public String getValue(String uri, String localName) {
        throw new UnsupportedOperationException();
    }

    public String getValue(String qName) {
        throw new UnsupportedOperationException();
    }

}
