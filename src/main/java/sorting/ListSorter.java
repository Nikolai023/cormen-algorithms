package sorting;

import java.util.Comparator;
import java.util.List;

public interface ListSorter {
    <T extends Comparable<? super T>> void sort(List<T> list);

    <T extends Comparable<? super T>> void sort(List<T> list, Comparator<T> comparator);
}
