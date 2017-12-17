package task9_28_11_2017_ColdSteel.entities;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
@XmlType(name = "metalType")
@XmlEnum
public enum MetalType {

    @XmlEnumValue("gold")
    GOLD("gold"),
    @XmlEnumValue("silver")
    SILVER("silver"),
    @XmlEnumValue("platinum")
    PLATINUM("platinum");
    private final String value;

    MetalType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MetalType fromValue(String v) {
        for (MetalType c : MetalType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    @Override
    public String toString() {
        return "MetalType{" +
                "value='" + value + '\'' +
                "} " + super.toString();
    }
}