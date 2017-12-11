package task5_16_11_2017_Knight.factory;

import task5_16_11_2017_Knight.knight.Knight;
import task5_16_11_2017_Knight.armor.Armor;


import java.util.List;

public abstract class AbstractEquipmentFactory {
    public abstract List<Armor> generateEquipmentSet();
    public abstract Knight createKnight();
}
