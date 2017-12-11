package task5_16_11_2017_Knight.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Name {
    VASYA,PETYA,VANYA,ALEHANDRO,KOLYA,IVANOVICH,SERGIO;

    private static final List<Name> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static Name randomName()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
