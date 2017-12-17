package task9_28_11_2017_ColdSteel.saxParser;

import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import task9_28_11_2017_ColdSteel.exceptions.IllegalXmlArgumentException;
import task9_28_11_2017_ColdSteel.exceptions.NoSuchXmlAttributeException;
import task9_28_11_2017_ColdSteel.entities.Knife;
import task9_28_11_2017_ColdSteel.entities.Knifes;
import task9_28_11_2017_ColdSteel.entities.MetalType;
import task9_28_11_2017_ColdSteel.entities.WoodType;

public class KnifesDocHandler extends DefaultHandler {
    private String currentElem;
    private Knife currentKnife;
    private List<Knife> knifes;
    private StringBuffer buffer = new StringBuffer();
    static Logger log = Logger.getLogger("KnifesSaxParser");

    public List<Knife> getKnifes() {
        return knifes;
    }

    @Override
    public void startDocument() {
        log.info("Creating document from file");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String data = null;
        currentElem = qName;
        try {
            switch (currentElem) {
                case "knifes":
                    knifes = new Knifes().getKnife();
                    break;

                case "knife":
                    currentKnife = new Knife();

                    data = attributes.getValue("name");
                    log.info("name=" + data);
                    if (data == null) {
                        throw new NoSuchXmlAttributeException("name");
                    } else {
                        currentKnife.setName(data);
                    }
                    break;

                case "knifeType":
                case "knifeHandy":
                case "knifeOrigin":
                    break;

                case "knifeVisual":
                    currentKnife.setKnifeVisual(new Knife.KnifeVisual());
                    break;

                case "knifeBlade":
                    Knife.KnifeVisual.KnifeBlade blade = new Knife.KnifeVisual.KnifeBlade();

                    // атрибуты лезвия
                    data = attributes.getValue("length");
                    log.info("length=" + data);
                    if (data == null) {
                        throw new NoSuchXmlAttributeException("length");
                    } else {
                        try {
                            blade.setLength(new Integer(data));
                        } catch (NumberFormatException e) {
                            throw new IllegalXmlArgumentException("length", data, true);
                        }
                    }

                    data = attributes.getValue("width");
                    log.info("width=" + data);
                    if (data == null) {
                        throw new NoSuchXmlAttributeException("width");
                    } else {
                        try {
                            blade.setWidth(new Integer(data));
                        } catch (NumberFormatException e) {
                            throw new IllegalXmlArgumentException("width", data, true);
                        }
                    }

                    data = attributes.getValue("metal");
                    log.info("metal=" + data);
                    if (data == null) {
                        throw new NoSuchXmlAttributeException("metal");
                    } else {
                        try {
                            blade.setMetal(MetalType.fromValue(data));
                        } catch (IllegalArgumentException e) {
                            throw new IllegalXmlArgumentException("metal", data, true);
                        }
                    }

                    currentKnife.getKnifeVisual().setKnifeBlade(blade);
                    break;

                case "knifeHandle":
                    currentKnife.getKnifeVisual().setKnifeHandle(new Knife.KnifeVisual.KnifeHandle());
                    break;

                case "wood":
                    Knife.KnifeVisual.KnifeHandle.Wood wood = new Knife.KnifeVisual.KnifeHandle.Wood();
                    log.info("wood=" + wood);
                    data = attributes.getValue("type");
                    log.info("wood type=" + data);
                    if (data == null) {
                        throw new NoSuchXmlAttributeException("type");
                    } else {
                        try {
                            wood.setType(WoodType.fromValue(data));
                        } catch (IllegalArgumentException e) {
                            throw new IllegalXmlArgumentException("type", data, true);
                        }
                    }
                    currentKnife.getKnifeVisual().getKnifeHandle().setWood(wood);
                    break;

                case "leatherCoated":
                    currentKnife.getKnifeVisual().getKnifeHandle().setLeatherCoated(new Object());
                    log.info("knifeHandle is leatherCoated");
                    break;

                case "plastic":
                    currentKnife.getKnifeVisual().getKnifeHandle().setPlastic(new Object());
                    log.info("knifeHandle is plastic");
                    break;

                case "collection":
                    log.info("this a collection item");
                    break;

                default:

                    // если елемент не найден
                    currentKnife = null;
                    log.error("Unknown element " + qName);
                    throw new SAXException("Unknown element " + qName);
            }
        } catch (NoSuchXmlAttributeException e) {

            // нужный елемент не найден
            log.error("required attribute is missing ");
            throw new SAXException(e.getMessage());
        } catch (IllegalXmlArgumentException e) {

            // неправильное значение атрибута
            log.error("wrong attribute value ");
            throw new SAXException(e.getMessage());
        } catch (NullPointerException e) {

            // неправильное построение объекта
            log.error("illegal order of construction of a knife");
            throw new SAXException("Illegal order of elements");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElem.equals("knifeType") ||
                currentElem.equals("knifeHandy") ||
                currentElem.equals("knifeOrigin") ||
                currentElem.equals("collection")) {

            buffer.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        String data = buffer.toString().trim();
        switch (qName) {

            case "knife":
                knifes.add(currentKnife);
                break;

            case "knifeType":
                currentKnife.setKnifeType(data);
                break;

            case "knifeHandy":
                currentKnife.setKnifeHandy(Integer.parseInt(data));
                break;

            case "knifeOrigin":
                currentKnife.setKnifeOrigin(data);
                break;

            case "collection":
                currentKnife.setCollection(Boolean.parseBoolean(data));
                break;

            default:
                break;
        }

        buffer.setLength(0);
    }

    @Override
    public void endDocument() throws SAXException {
        log.info("End of document");
    }
}
