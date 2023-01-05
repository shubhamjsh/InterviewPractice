package org.example.review_system.utils;

import java.util.Random;

public class Utils {
    public static Random random = new Random();

    public static long getRandomLong() {
        return random.nextLong();
    }
    public static int getRandomInt() {
        return random.nextInt();
    }
}
