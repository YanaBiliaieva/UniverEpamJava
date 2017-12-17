package task09_28_11_2017_ColdSteelTests;

import org.junit.*;
import task9_28_11_2017_ColdSteel.domParser.KnifesDomParser;
import task9_28_11_2017_ColdSteel.entities.Knife;
import task9_28_11_2017_ColdSteel.entities.MetalType;
import task9_28_11_2017_ColdSteel.saxParser.KnifesSaxParser;
import task9_28_11_2017_ColdSteel.staxParser.KnifesStaxParser;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ParsersTests {
    final static String xmlFile = "src/main/java/task9_28_11_2017_ColdSteel/xml/xmlFile.xml";
    static KnifesSaxParser knifesSaxParser;
    static KnifesStaxParser knifesStaxParser;
    static KnifesDomParser knifesDomParser;
    static List<Knife> knifesFromDom;
    static List<Knife> knifesFromSax;
    static List<Knife> knifesFromStax;
    static int handy,bladeLength,bladeWidth;
    static MetalType steel;
    @BeforeClass
    public static void init(){
        knifesDomParser = new KnifesDomParser();
        knifesSaxParser = new KnifesSaxParser();
        knifesStaxParser = new KnifesStaxParser();
        knifesFromDom = knifesDomParser.parseDocument(xmlFile);
        knifesFromSax = knifesSaxParser.parseDocument(xmlFile);
        knifesFromStax = knifesStaxParser.parseDocument(xmlFile);
        handy=1;
        bladeLength=21;
        bladeWidth=10;
        steel=MetalType.GOLD;
    }
    @AfterClass
    public static void tearDown(){
        knifesSaxParser=null;
        knifesStaxParser=null;
        knifesDomParser=null;
        knifesFromDom=null;
        knifesFromSax=null;
        knifesFromStax=null;
    }
    @Test
    public void testObjects(){
        assertEquals(knifesFromDom.get(0).getName(), knifesFromSax.get(0).getName());
        assertEquals(knifesFromDom.get(0).getName(), knifesFromStax.get(0).getName());
    }

    @Test
    public void testObjectFromDomParser(){
        int handy=1;
        int bladeLength=21;
        int bladeWidth=10;
        MetalType steel=MetalType.GOLD;
        assertEquals(knifesFromDom.get(0).getName(), "GoldenSword");
        assertEquals(knifesFromDom.get(0).getKnifeType(), "sword");
        assertEquals(knifesFromDom.get(0).getKnifeHandy(), handy);
        assertEquals(knifesFromDom.get(0).getKnifeOrigin(), "UK");
        assertEquals(knifesFromDom.get(0).getKnifeVisual().getKnifeBlade().getLength(), bladeLength);
        assertEquals(knifesFromDom.get(0).getKnifeVisual().getKnifeBlade().getWidth(), bladeWidth);
        assertEquals(knifesFromDom.get(0).getKnifeVisual().getKnifeBlade().getMetal(),steel);
        assertEquals(knifesFromDom.get(0).isCollection(), true);
    }
    @Test
    public void testObjectFromSaxParser(){
        assertEquals(knifesFromSax.get(0).getName(), "GoldenSword");
        assertEquals(knifesFromSax.get(0).getKnifeType(), "sword");
        assertEquals(knifesFromSax.get(0).getKnifeHandy(), handy);
        assertEquals(knifesFromSax.get(0).getKnifeOrigin(), "UK");
        assertEquals(knifesFromSax.get(0).getKnifeVisual().getKnifeBlade().getLength(), bladeLength);
        assertEquals(knifesFromSax.get(0).getKnifeVisual().getKnifeBlade().getWidth(), bladeWidth);
        assertEquals(knifesFromSax.get(0).getKnifeVisual().getKnifeBlade().getMetal(),steel);
        assertEquals(knifesFromSax.get(0).isCollection(), true);
    }
    @Test
    public void testObjectFromStaxParser(){
        assertEquals(knifesFromStax.get(0).getName(), "GoldenSword");
        assertEquals(knifesFromStax.get(0).getKnifeType(), "sword");
        assertEquals(knifesFromStax.get(0).getKnifeHandy(), handy);
        assertEquals(knifesFromStax.get(0).getKnifeOrigin(), "UK");
        assertEquals(knifesFromStax.get(0).getKnifeVisual().getKnifeBlade().getLength(), bladeLength);
        assertEquals(knifesFromStax.get(0).getKnifeVisual().getKnifeBlade().getWidth(), bladeWidth);
        assertEquals(knifesFromStax.get(0).getKnifeVisual().getKnifeBlade().getMetal(),steel);
        assertEquals(knifesFromStax.get(0).isCollection(), true);
    }
}
