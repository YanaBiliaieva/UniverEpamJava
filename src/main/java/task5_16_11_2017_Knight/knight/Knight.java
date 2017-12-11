package task5_16_11_2017_Knight.knight;

import task5_16_11_2017_Knight.armor.Armor;
import task5_16_11_2017_Knight.knight.Human;
import task5_16_11_2017_Knight.utils.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Knight extends Human {
    private List<Armor> equipment;
    public List<Armor> getEquipment() {
        return equipment;
    }
    public void setEquipment(List<Armor> equipment) {
        this.equipment = equipment;
    }

    public Name name() {
        Name name = Name.randomName();
        return name;
    }

    public int age() {
        Random rand = new Random();
        int  age = 18+rand.nextInt(90-18+1);
        return age;
    }

    public Knight(ArrayList<Armor> equipment) {
        this.equipment=equipment;
        super.setAge(age());
        super.setName(name());
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "My name is " +String.valueOf(name())+". My age is "+age()+" years. "+
                "My equipment:" + equipment.toString() +'\n';
    }
}
