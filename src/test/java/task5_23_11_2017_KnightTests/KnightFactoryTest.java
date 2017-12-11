package task5_23_11_2017_KnightTests;

import task5_16_11_2017_Knight.armor.*;
import task5_16_11_2017_Knight.factory.KnightFactory;
import task5_16_11_2017_Knight.knight.Knight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task5_16_11_2017_Knight.utils.Color;
import task5_16_11_2017_Knight.utils.Material;

import java.util.List;
import static org.junit.Assert.assertTrue;

public class KnightFactoryTest {
    KnightFactory knightFactory;
    Belt belt;
    Boots boots;
    Breastplate breastplate;
    Cuisse cuisse;
    Gauntlets gauntlets;
    Helm helm;

    @Before
    public void init() {
       knightFactory=new KnightFactory();
        belt=knightFactory.generateBelt();
        boots=knightFactory.generateBoots();
        breastplate=knightFactory.generateBreastplate();
        cuisse=knightFactory.generateCuisse();
        gauntlets=knightFactory.generateGauntlets();
        helm=knightFactory.generateHelm();
    }
    @After
    public void tearDown() {
        knightFactory=null;
    }
    @Test
    public void newKnightIsCreatedTest() {
        Knight knight=knightFactory.createKnight();
        Boolean aBoolean=false;

        if(knight.age()!=0&&knight.name()!=null&&knight.getEquipment()!=null){
            aBoolean=true;
        }
        assertTrue(aBoolean);
    }
    @Test
    public void generateEquipmentSetTest(){
        List<Armor> armor=knightFactory.generateEquipmentSet();
        boolean b=false;
        if(!armor.isEmpty()){
            for (int i = 0; i < armor.size(); i++) {
               if(!(armor.get(i) instanceof Armor)) {
                   break;
               }else b=true;
            }

        }
        assertTrue(b);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badColorBeltTest(){
        Color color=Color.BLACK;
        color=null;
        belt.setColor(color);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badMaterialBeltTest(){
        Material  material=Material.BRONZE;
        material=null;
        belt.setMaterial(material);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongWeightBeltTest(){
        belt.setWeight(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongPriceBeltTest(){
        belt.setPrice(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badColorBootsTest(){
        Color color=Color.BLACK;
        color=null;
        boots.setColor(color);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badMaterialBootsTest(){
        Material  material=Material.BRONZE;
        material=null;
        boots.setMaterial(material);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongWeightBootsTest(){
        boots.setWeight(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongPriceBootsTest(){
        boots.setPrice(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void badColorBreastplateTest(){
        Color color=Color.BLACK;
        color=null;
        breastplate.setColor(color);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badMaterialBreastplateTest(){
        Material  material=Material.BRONZE;
        material=null;
        breastplate.setMaterial(material);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongWeightBreastplateTest(){
        breastplate.setWeight(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongPriceBreastplateTest(){
        breastplate.setPrice(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badColorCuisseTest(){
        Color color=Color.BLACK;
        color=null;
        cuisse.setColor(color);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badMaterialCuisseTest(){
        Material  material=Material.BRONZE;
        material=null;
        cuisse.setMaterial(material);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongWeightCuisseTest(){
        cuisse.setWeight(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongPriceCuisseTest(){
        cuisse.setPrice(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badColorGauntletsTest(){
        Color color=Color.BLACK;
        color=null;
        gauntlets.setColor(color);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badMaterialGauntletsTest(){
        Material  material=Material.BRONZE;
        material=null;
        gauntlets.setMaterial(material);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongWeightGauntletsTest(){
        gauntlets.setWeight(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongPriceGauntletsTest(){
        gauntlets.setPrice(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void badColorHelmTest(){
        Color color=Color.BLACK;
        color=null;
        helm.setColor(color);
    }
    @Test(expected = IllegalArgumentException.class)
    public void badMaterialHelmTest(){
        Material  material=Material.BRONZE;
        material=null;
        helm.setMaterial(material);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongWeightHelmTest(){
        helm.setWeight(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongPriceHelmTest(){
        helm.setPrice(-1);
    }
}
