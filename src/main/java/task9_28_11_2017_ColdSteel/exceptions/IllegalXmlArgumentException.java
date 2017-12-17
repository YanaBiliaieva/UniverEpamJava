package task9_28_11_2017_ColdSteel.exceptions;

public class IllegalXmlArgumentException extends Exception {
    private static final long serialVersionUID = 1L;
    private String element;
    private boolean isAttribute;

    public IllegalXmlArgumentException(String name, String value, boolean isAttr) {
        super(value);
        element = name;
        isAttribute = isAttr;
    }

    @Override
    public String getMessage() {
        return "Value " + super.getMessage() + " is not allowed for " +
                (isAttribute ? "attribute" : "element") + element;
    }
}