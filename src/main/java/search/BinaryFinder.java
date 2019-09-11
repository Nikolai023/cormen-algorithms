package search;

import java.util.List;

public class BinaryFinder implements Finder {

    @Override
    public <T extends Comparable<? super T>> int find(List<T> list, T item) {
        return find(list, item, 0, list.size());
    }

    private <T extends Comparable<? super T>> int find(List<T> list, T item, int left, int right) {
        int mid = left + (right - left) / 2;

        if (left >= right) {
            return -left - 1;
        }

        T midElem = list.get(mid);
        if (item == list.get(mid)) {
            return mid;
        }

        if (item.compareTo(midElem) > 0) {
            return find(list, item, mid + 1, right);
        } else {
            return find(list, item, left, mid);
        }
    }
}
