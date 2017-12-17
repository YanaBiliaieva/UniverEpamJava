package task9_28_11_2017_ColdSteel.entities;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
@XmlType(name = "woodType")
@XmlEnum
public enum WoodType {

    @XmlEnumValue("maple")
	MAPLE("Maple"),
    @XmlEnumValue("beech")
    BEECH("beech"),
    @XmlEnumValue("bamboo")
    BAMBOO("bamboo");
    private final String value;

    WoodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WoodType fromValue(String v) {
        for (WoodType c : WoodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    @Override
    public String toString() {
        return "WoodType{" +
                "value='" + value + '\'' +
                "} " + super.toString();
    }
}