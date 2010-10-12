package com.inggs.markup;

import com.inggs.markup.parser.MarkupReader;

/**
 * @author Andrew Inggs
 */
public class MarkupDriver {

    public static void main(String[] args) {
        MarkupReader markupParser = new MarkupReader(System.in);
        markupParser.parse();
    }

}
