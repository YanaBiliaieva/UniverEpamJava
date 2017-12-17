package task9_28_11_2017_ColdSteel.exceptions;

public class NoSuchXmlAttributeException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoSuchXmlAttributeException(String attribute) {
        super(attribute);
    }

    @Override
    public String getMessage() {
        return "Attribute \'" + super.getMessage() + "\' not found";
    }
}