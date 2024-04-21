import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParser saxParser = SAXParserFactory.newDefaultInstance().newSAXParser();
        DataHandler handler = new DataHandler();
        saxParser.parse(new File("Popular_Baby_Names_NY.xml"),handler);
        System.out.println("\n\nAll TAGS");
        for (String str: handler.getTags()) {
            if(str!=null) System.out.println(str);
        }
    }
}

