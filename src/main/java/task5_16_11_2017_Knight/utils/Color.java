package task5_16_11_2017_Knight.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Color {
    GREEN,RED,YELLOW,BLACK,BLUE,WHITE,PURPLE;

    private static final List<Color> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static Color randomColor()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
