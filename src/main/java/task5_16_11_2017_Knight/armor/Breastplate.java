package task5_16_11_2017_Knight.armor;

import task5_16_11_2017_Knight.utils.Color;
import task5_16_11_2017_Knight.utils.Material;


public class Breastplate extends Armor {
    public Breastplate(int weight, int price, Color color, Material material) {
        super(weight, price, color, material);
    }

    @Override
    public String toString() {
        return "Breastplate: " + super.toString()+'\n';
    }

}
