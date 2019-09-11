package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomListGenerator {
    private static final int LIST_DEFAULT_CAPACITY = 10;
    private static final int RANDOM_DEFAULT_BOUND = 10;

    private int capacity = LIST_DEFAULT_CAPACITY;
    private int bounds = RANDOM_DEFAULT_BOUND;

    public List<Integer> generate() {
        List<Integer> list = new ArrayList<>(capacity);

        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            list.add(bounds == 0 ? random.nextInt() : random.nextInt(bounds));
        }

        return list;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBounds(int bounds) {
        this.bounds = bounds;
    }
}
