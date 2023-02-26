package org.example.utils;

import java.util.Random;

public class returnRandomAmount {
    public static int getRandomIntInARange(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().orElse(1);
    }
}
