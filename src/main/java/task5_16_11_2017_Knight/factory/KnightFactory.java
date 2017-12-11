package task5_16_11_2017_Knight.factory;

import task5_16_11_2017_Knight.knight.Knight;
import task5_16_11_2017_Knight.armor.*;
import task5_16_11_2017_Knight.armor.Armor;
import task5_16_11_2017_Knight.utils.Color;
import task5_16_11_2017_Knight.utils.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KnightFactory extends AbstractEquipmentFactory{
    public KnightFactory() {
    }
    @Override
    public List<Armor> generateEquipmentSet() {
        List<Armor> equipmentSet=new ArrayList<Armor>();
        Belt belt=generateBelt();
        equipmentSet.add(belt);
        Boots boots=generateBoots();
        equipmentSet.add(boots);
        Breastplate breastplate=generateBreastplate();
        equipmentSet.add(breastplate);
        Cuisse cuisse=generateCuisse();
        equipmentSet.add(cuisse);
        Gauntlets gauntlets=generateGauntlets();
        equipmentSet.add(gauntlets);
        Helm helm=generateHelm();
        equipmentSet.add(helm);
        return equipmentSet;
    }
    @Override
    public Knight createKnight() {
        ArrayList<Armor> armors= (ArrayList<Armor>) generateEquipmentSet();
        Knight knight=new Knight(armors);
        return knight;
    }
    public Belt generateBelt(){
        int weight=3+(int)(Math.random()*((10-3)+1)); //((max - min) + 1) + min;
        Material randomMaterial=Material.randomMaterial();//Min + (int)(Math.random() * ((Max - Min) + 1))
        Color color=Color.randomColor();
        int price=10+(int)(Math.random()*((50-10)+1));
        return new Belt(weight,price,color,randomMaterial);
    }
    public Boots generateBoots(){
        int weight=5+(int)(Math.random()*((15-5)+1));
        Material randomMaterial=Material.randomMaterial();
        Color color=Color.randomColor();
        int price=20+(int)(Math.random()*((50-20)+1));
        return new Boots(weight,price,color,randomMaterial);
    }
    public Breastplate generateBreastplate(){
        int weight=5+(int)(Math.random()*((70-30)+1));
        Material randomMaterial=Material.randomMaterial();
        Color color=Color.randomColor();
        int price=40+(int)(Math.random()*((90-40)+1));
        return new Breastplate(weight,price,color,randomMaterial);
    }
    public Cuisse generateCuisse(){
        int weight=20+(int)(Math.random()*((50-20)+1));
        Material randomMaterial=Material.randomMaterial();
        Color color=Color.randomColor();
        int price=30+(int)(Math.random()*((70-30)+1));
        return new Cuisse(weight,price,color,randomMaterial);
    }
    public Gauntlets generateGauntlets(){
        int weight=10+(int)(Math.random()*((30-10)+1));
        Material randomMaterial=Material.randomMaterial();
        Color color=Color.randomColor();
        int price=20+(int)(Math.random()*((40-20)+1));
        return new Gauntlets(weight,price,color,randomMaterial);
    }
    public Helm generateHelm(){
        int weight=13+(int)(Math.random()*((27-13)+1));
        Material randomMaterial=Material.randomMaterial();
        Color color=Color.randomColor();
        int price=20+(int)(Math.random()*((40-20)+1));
        return new Helm(weight,price,color,randomMaterial);
    }

}
































