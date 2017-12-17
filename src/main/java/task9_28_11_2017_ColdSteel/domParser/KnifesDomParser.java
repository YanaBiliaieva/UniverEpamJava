package task9_28_11_2017_ColdSteel.domParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import task9_28_11_2017_ColdSteel.entities.*;

public class KnifesDomParser {
    static Logger log = Logger.getLogger(KnifesDomParser.class.getName());

    static {
        new DOMConfigurator().doConfigure("src\\main\\resources\\log4j.xml", LogManager.getLoggerRepository());
    }

    public Document getDocument(String filename) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File(filename));
        log.info("----------------------DOM parser---------------------------------------");
        log.info("Created document from file: " + filename);
        return doc;
    }

    public List<Knife> parseDocument(String filename) {

        List<Knife> knifes = new ArrayList<>();
        Knife knife = null;
        Node currentNode = null;
        try {
            Document doc = getDocument(filename);
            NodeList records = doc.getDocumentElement().getElementsByTagName("knife");
            for (int i = 0; i < records.getLength(); ++i) {
                currentNode = records.item(i);
                // создаем новый инстанс ножа
                knife = new Knife();
                // берем имя
                knife.setName(((Element) currentNode).getAttribute("name"));
                log.info("name= " + knife.getName());
                // берем теги наследников
                NodeList children = currentNode.getChildNodes();
                for (int j = 0; j < children.getLength(); ++j) {
                    Node node = children.item(j);

                    if (node instanceof Element) {
                        switch (node.getNodeName()) {
                            case "knifeType":
                                knife.setKnifeType(node.getTextContent());
                                log.info("type= " + knife.getKnifeType());
                                break;

                            case "knifeHandy":
                                knife.setKnifeHandy(Integer.parseInt(node.getTextContent()));
                                log.info("handy= " + knife.getKnifeHandy());
                                break;

                            case "knifeOrigin":
                                knife.setKnifeOrigin(node.getTextContent());
                                log.info("Origin= " + knife.getKnifeOrigin());
                                break;

                            case "knifeVisual":
                                knife.setKnifeVisual(new Knife.KnifeVisual());
                                NodeList visualAttrs = node.getChildNodes();
                                for (int k = 0; k < visualAttrs.getLength(); ++k) {
                                    Node visualNode = visualAttrs.item(k);

                                    if (visualNode instanceof Element) {
                                        switch (visualNode.getNodeName()) {

                                            case "knifeBlade":
                                                Knife.KnifeVisual.KnifeBlade blade = new Knife.KnifeVisual.KnifeBlade();
                                                blade.setLength(new Integer(((Element) visualNode).getAttribute("length")));
                                                blade.setWidth(new Integer(((Element) visualNode).getAttribute("width")));
                                                blade.setMetal(MetalType.fromValue(((Element) visualNode).getAttribute("metal")));
                                                knife.getKnifeVisual().setKnifeBlade(blade);
                                                log.info("KnifeVisual.KnifeBlade: Length=" + knife.getKnifeVisual().getKnifeBlade().getLength()
                                                        + " Width=" + knife.getKnifeVisual().getKnifeBlade().getWidth() + " Metal=" + knife.getKnifeVisual().getKnifeBlade().getMetal().value());
                                                break;

                                            case "knifeHandle":
                                                knife.getKnifeVisual().setKnifeHandle(new Knife.KnifeVisual.KnifeHandle());
                                                // проверяем древесину
                                                NodeList woodNode = ((Element) visualNode).getElementsByTagName("wood");
                                                if (woodNode.getLength() > 0) {
                                                    Knife.KnifeVisual.KnifeHandle.Wood wood = new Knife.KnifeVisual.KnifeHandle.Wood();
                                                    wood.setType(WoodType.fromValue(((Element) woodNode.item(0)).getAttribute("type")));
                                                    knife.getKnifeVisual().getKnifeHandle().setWood(wood);
                                                    log.info("knifeHandle.Material= " + knife.getKnifeVisual().getKnifeHandle().getWood());
                                                    break;
                                                }
                                                // проверяем кожу
                                                if (((Element) visualNode).getElementsByTagName("leatherCoated").getLength() > 0) {
                                                    knife.getKnifeVisual().getKnifeHandle().setLeatherCoated(new Object());
                                                    log.info("knifeHandle.Material= " + knife.getKnifeVisual().getKnifeHandle().getLeatherCoated());
                                                    break;
                                                }
                                                // проверяем пластмасу
                                                if (((Element) visualNode).getElementsByTagName("plastic").getLength() > 0) {
                                                    knife.getKnifeVisual().getKnifeHandle().setPlastic(new Object());
                                                    log.info("knifeHandle.Material= " + knife.getKnifeVisual().getKnifeHandle().getPlastic());
                                                    break;
                                                }

                                            default:
                                                knife = null;
                                                log.error("Illegal Argument Exception. Cannot create knife");
                                                throw new IllegalArgumentException();
                                        }
                                    }
                                }
                                break;
                            case "collection": //коллекционный ли
                                knife.setCollection(Boolean.parseBoolean(node.getTextContent()));
                                log.info("collection="+knife.isCollection());
                                break;

                            default:
                                knife = null;
                                log.error(" Illegal Argument Exception. Cannot create knife");
                                throw new IllegalArgumentException();

                        }
                    }
                }
                knifes.add(knife);
                log.info("DOM parser: creation of knife number" + i + " is finished!");
            }
        } catch (Exception e) {
            log.error("DOM parser: error while parsing document" + e.getMessage());
        }
        return knifes;
    }
}
