package xml;

import mybeans.Data;
import mybeans.DataSheet;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.*;

public class MySAXParser {
    private static DataSheet sheet;

    public static DataSheet XMLReadData(String filename) {
        sheet = new DataSheet();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
        Handler handler = new Handler();
        try {
            parser.parse(new File(filename), handler);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        return sheet;
    }

    public static class Handler extends DefaultHandler {
        private double x;
        private double y;
        private String date;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("point")) {
                x = Double.parseDouble(attributes.getValue("x"));
                y = Double.parseDouble(attributes.getValue("y"));
                date = attributes.getValue("date");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("point")) {
                sheet.addDataItem(new Data(x, y, date));
            }
        }
    }
}