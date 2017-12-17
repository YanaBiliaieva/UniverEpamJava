package task9_28_11_2017_ColdSteel.staxParser;
import java.io.FileReader;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import task9_28_11_2017_ColdSteel.entities.Knife;
import task9_28_11_2017_ColdSteel.saxParser.KnifesDocHandler;

public class KnifesStaxParser {
    private KnifesDocHandler docHandler = new KnifesDocHandler();
    static Logger log = Logger.getLogger("KnifesStaxParser");
    private void startElement(String localName, Attributes attrs) {
        try {
            docHandler.startElement(null, null, localName, attrs);
        } catch (SAXException e) {
            log.error("StAX parser: error while parsing document");
        }
    }

    private void endElement(String localName) {
        try {
            docHandler.endElement(null, null, localName);
        } catch (SAXException e) {
            log.error("StAX parser: error while parsing document");
        }
    }

    public List<Knife> parseDocument(String filename) {
        try {
            // get the default factory instance
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(filename));
            log.info("-----------------------------STAX parser---------------------------------------");
            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamReader.START_DOCUMENT:

                        break;
                    case XMLStreamReader.END_DOCUMENT:
                        log.info("-----------------------------end---------------------------------------");
                        break;

                    case XMLStreamReader.START_ELEMENT:
                        // получаем список всех атрибутов
                        MyAttributes attrs = null;
                        if (reader.getAttributeCount() > 0) {
                            attrs = new MyAttributes();
                            for (int i = 0; i < reader.getAttributeCount(); ++i) {
                                attrs.addAttribute(reader.getAttributeLocalName(i), reader.getAttributeValue(i));
                                log.info(""+reader.getAttributeLocalName(i).toString()+" = "+ reader.getAttributeValue(i).toString());
                            }
                        }
                        startElement(reader.getLocalName(), attrs);
                        break;

                    case XMLStreamReader.CHARACTERS:
                        docHandler.characters(reader.getTextCharacters(),
                                reader.getTextStart(), reader.getTextLength());
                        break;

                    case XMLStreamReader.END_ELEMENT:
                        endElement(reader.getLocalName());
                        break;

                    default:
                        break;
                }
            }

        } catch (Exception e) {
            log.error("StAX parser: error while parsing the document");
        }

        return docHandler.getKnifes();
    }
}


