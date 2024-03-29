package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public interface ListSorter {
    static List<ListSorter> allSortersList() {
        return Arrays.asList(
                new InsertionSorter(),
                new SelectionSorter(),
                new MergeSorter(),
                new RecursiveInsertionSorter()
        );

    }

    default <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, Comparator.naturalOrder());
    }

    <T extends Comparable<? super T>> void sort(List<T> list, Comparator<T> comparator);
}
