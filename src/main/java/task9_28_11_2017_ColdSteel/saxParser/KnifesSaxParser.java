package task9_28_11_2017_ColdSteel.saxParser;

import org.apache.log4j.Logger;
import task9_28_11_2017_ColdSteel.entities.Knife;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class KnifesSaxParser {
    static Logger log = Logger.getLogger("KnifesSaxParser");
    public List<Knife> parseDocument(String filename) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            KnifesDocHandler docHandler = new KnifesDocHandler();

            if (docHandler != null) {
                log.info("--------------------------SAX parser:---------------------------------------");
                parser.parse(new File(filename), docHandler);

                return docHandler.getKnifes();
            }
        } catch (Exception e) {
            log.error("SAX parser: error while parsing document");
        }
        return null;
    }
}
