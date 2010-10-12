package com.inggs.markup.xml;

import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * From <a href="http://www.cafeconleche.org/books/xmljava/chapters/ch06s03.html">.
 */
public class ExtractorDriver {

    public static void main(String[] args) {

        if (args.length <= 0) {
            System.out.println(
                    "Usage: java ExtractorDriver url"
            );
            return;
        }

        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();

            // Since this just writes onto the console, it's best
            // to use the system default encoding, which is what
            // we get by not specifying an explicit encoding here.
            Writer out = new OutputStreamWriter(System.out);
            ContentHandler handler = new TextExtractor(out);
            parser.setContentHandler(handler);

            parser.parse(args[0]);

            out.flush();
        }
        catch (Exception e) {
            System.err.println(e);
        }

    }

}
