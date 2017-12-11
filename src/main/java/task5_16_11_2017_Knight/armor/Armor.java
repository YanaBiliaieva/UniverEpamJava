package task5_16_11_2017_Knight.armor;

import task5_16_11_2017_Knight.utils.Color;
import task5_16_11_2017_Knight.utils.Material;

public abstract class Armor {
   private int weight;
   private int price;
   private Color color;
   private Material material;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight>0){
            this.weight = weight;
        } else throw new IllegalArgumentException("Wrong weight");
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price>0){
            this.price = price;
        } else throw new IllegalArgumentException("Wrong price");

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if(color!=null){
            this.color = color;
        } else throw new IllegalArgumentException("Wrong color");
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        if(material!=null){
            this.material = material;
        }else throw new IllegalArgumentException("Wrong material");
    }

    public Armor(int weight, int price, Color color, Material material){
       this.color=color;
       this.price=price;
       this.weight=weight;
       this.material=material;
   }

    @Override
    public String toString() {
        return  " weight=" + weight +
                ", price=" + price +
                ", color=" + color +
                ", material=" + material;
    }
}
