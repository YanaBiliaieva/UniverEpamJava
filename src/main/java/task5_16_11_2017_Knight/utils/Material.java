package task5_16_11_2017_Knight.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Material {
    SILVER,GOLD,METAL,BRONZE,WOOD;
    private static final List<Material> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static Material randomMaterial()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
