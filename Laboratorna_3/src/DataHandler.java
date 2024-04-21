import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class DataHandler extends DefaultHandler {
    public String[] getTags() {
        return tags;
    }

    private String[] tags;
    private int cnt = 0;

    public DataHandler() {
        tags = new String[10];

    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName);
        for (int i = 0; i < cnt; i++) {
            if (tags[i].compareTo(qName) == 0) {
                return;
            }
        }
        tags[cnt++] = qName;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String info = new String(ch, start, length);
        info = info.replace("\n", "").trim();
        if (!info.isEmpty()) {
            System.out.println("\t" + info.trim());
        }
    }
}
