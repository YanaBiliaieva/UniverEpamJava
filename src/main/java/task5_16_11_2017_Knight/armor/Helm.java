package task5_16_11_2017_Knight.armor;

import task5_16_11_2017_Knight.utils.Color;
import task5_16_11_2017_Knight.utils.Material;

public class Helm extends Armor {

    public Helm(int weight, int price, Color color, Material material) {
        super(weight, price, color, material);
    }

    @Override
    public String toString() {
        return "Helm: " + super.toString()+'\n';
    }
}
