package xml;

import mybeans.Data;
import mybeans.DataSheet;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public abstract class WriteToXML {
    private static Document document;

    public static void saveXMLDoc(DataSheet sheet, String filepath) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        document = builder.newDocument();
        addRootElement("list");
        for (Data data : sheet.getDataTable()) {
            addElement(data);
        }

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = factory.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }
        transformer.setOutputProperty(OutputKeys.ENCODING, "Windows-1251");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filepath.trim()));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addRootElement(String name) {
        Element root = document.createElement(name);
        document.appendChild(root);
    }

    private static void addElement(Data data) {
        Element dataEl = document.createElement("point");
        Attr attr = document.createAttribute("x");
        attr.setValue(String.valueOf(data.getX()));
        dataEl.setAttributeNode(attr);
        attr = document.createAttribute("y");
        attr.setValue(String.valueOf(data.getY()));
        dataEl.setAttributeNode(attr);
        attr = document.createAttribute("date");
        attr.setValue(String.valueOf(data.getDate()));
        dataEl.setAttributeNode(attr);
        document.getDocumentElement().appendChild(dataEl);
    }
}