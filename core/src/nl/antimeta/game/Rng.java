package nl.antimeta.game;

import java.util.concurrent.ThreadLocalRandom;

public class Rng {
    public static int randInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int nextInt(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }
}
