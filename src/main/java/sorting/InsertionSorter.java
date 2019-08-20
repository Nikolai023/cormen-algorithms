package sorting;

import java.util.Comparator;
import java.util.List;

public class InsertionSorter implements ListSorter {

    public InsertionSorter() {
    }

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, Comparator.naturalOrder());
    }

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list, Comparator<T> comparator) {
        for (int j = 1; j < list.size(); j++) {
            T key = list.get(j);

            int i = j - 1;
            while (i >= 0 && comparator.compare(list.get(i), key) > 0) {
                list.set(i + 1, list.get(i));
                i = i - 1;
            }
            list.set(i + 1, key);
        }
    }
}
