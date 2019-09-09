package search;

import java.util.List;

public class BinaryFinder implements Finder {

    @Override
    public <T extends Comparable<? super T>> int find(List<T> list, T item) {
        return -1;
    }
}
