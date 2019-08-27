package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomListGenerator {
    private static final int LIST_DEFAULT_CAPACITY = 10;
    private static final int RANDOM_DEFAULT_BOUND = 10;

    public static List<Integer> generateRandomIntegerList() {
        return generateRandomIntegerList(LIST_DEFAULT_CAPACITY, RANDOM_DEFAULT_BOUND);
    }

    public static List<Integer> generateRandomIntegerList(int capacity) {
        return generateRandomIntegerList(capacity, RANDOM_DEFAULT_BOUND);
    }

    private static List<Integer> generateRandomIntegerList(int capacity, int bounds) {
        List<Integer> list = new ArrayList<>(capacity);

        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            list.add(bounds == 0 ? random.nextInt() : random.nextInt(bounds));
        }

        return list;
    }
}
