package sort;

import java.util.Comparator;
import java.util.List;

public interface ListSorter {
    default <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, Comparator.naturalOrder());
    }

    <T extends Comparable<? super T>> void sort(List<T> list, Comparator<T> comparator);
}
