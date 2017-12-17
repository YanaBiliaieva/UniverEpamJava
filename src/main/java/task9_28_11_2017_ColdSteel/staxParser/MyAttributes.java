package task9_28_11_2017_ColdSteel.staxParser;

import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.Map;

public class MyAttributes implements Attributes {
    Map<String, String> attrs = new HashMap<>();

    public String addAttribute(String name, String value) {
        return attrs.put(name, value);
    }

    @Override
    public int getLength() {
        return attrs.size();
    }

    @Override
    public String getValue(String qName) {
        return attrs.get(qName);
    }

    @Override
    public int getIndex(String qName) {
        return 0;
    }

    @Override
    public int getIndex(String uri, String localName) {
        return 0;
    }

    @Override
    public String getLocalName(int index) {
        return null;
    }

    @Override
    public String getQName(int index) {
        return null;
    }

    @Override
    public String getType(int index) {
        return null;
    }

    @Override
    public String getType(String qName) {
        return null;
    }

    @Override
    public String getType(String uri, String localName) {
        return null;
    }

    @Override
    public String getURI(int index) {
        return null;
    }

    @Override
    public String getValue(int index) {
        return null;
    }

    @Override
    public String getValue(String uri, String localName) {
        return null;
    }

}