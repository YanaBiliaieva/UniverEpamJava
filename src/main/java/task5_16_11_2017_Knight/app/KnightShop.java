package task5_16_11_2017_Knight.app;

import task5_16_11_2017_Knight.factory.KnightFactory;
import task5_16_11_2017_Knight.armor.Armor;
import task5_16_11_2017_Knight.knight.Knight;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Biliaieva Yana
 * 7.	Рыцарь. Определить иерархию амуниции рыцаря. Экипировать рыцаря. Посчитать стоимость.
 * Провести сортировку амуниции на основе веса.
 * Найти элементы амуниции, соответствующие заданному диапазону параметров цены.
 */
public class KnightShop {

    public static void main(String[] args) {
        // Экипировать рыцаря.
        KnightFactory knightFactory =new KnightFactory();
        Knight knight= knightFactory.createKnight();
        //Посчитать стоимость.
        Armor[] equipment= knight.getEquipment().toArray(new Armor[6]);
        int armoryPrice=countAllEquipmentPrice(equipment);
        System.out.println("Total armor price="+armoryPrice+".");
        //Провести сортировку амуниции на основе веса.
        Armor[] sortedArmor=sortArmorByWeight(equipment);
        System.out.println("Sorted equipment by weight:");
        System.out.println(Arrays.toString(sortedArmor));
    }
    private static int countAllEquipmentPrice(Armor[] equipment){
        int price=0;
        for (int i = 0; i <equipment.length ; i++) {
            price+=equipment[i].getPrice();
        }
        return price;
    }
    private static Armor[] sortArmorByWeight(Armor[] equipment){
        Armor[] sortedArmor=equipment;
        Arrays.sort(sortedArmor, new Comparator<Armor>() {
            public int compare(Armor armor1, Armor armor2) {
                return armor1.getWeight() - armor2.getWeight();
            }
        });
        return sortedArmor;
    }
}
