package com.inggs.markup;

import com.inggs.markup.parser.MarkupReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Andrew Inggs
 */
public class MarkupDriver {

    public static void main(String[] args) throws TransformerException, SAXException, FileNotFoundException {
        InputStream inputStream;
        if (args.length > 0) {
            inputStream = new FileInputStream(args[0]);
        } else {
            inputStream = System.in;
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(); // identity transformer
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        Source xmlSource = new SAXSource(new MarkupReader(), new InputSource(inputStream));
        Result result = new StreamResult(new BufferedOutputStream(System.out));
        transformer.transform(xmlSource, result);
    }

}
