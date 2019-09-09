package sort;

import java.util.Comparator;
import java.util.List;

public class RecursiveInsertionSorter implements ListSorter {

    public RecursiveInsertionSorter() {
    }

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list, Comparator<T> comparator) {
        recursiveInsertionSort(list, comparator, list.size() - 1);
    }

    private <T extends Comparable<? super T>> void recursiveInsertionSort(List<T> list, Comparator<T> comparator, int currentElemIndex) {
        if (currentElemIndex <= 0) {
            return;
        }

        recursiveInsertionSort(list, comparator, currentElemIndex - 1);

        T key = list.get(currentElemIndex);

        int i = currentElemIndex - 1;
        while (i >= 0 && comparator.compare(list.get(i), key) > 0) {
            list.set(i + 1, list.get(i));
            i = i - 1;
        }
        list.set(i + 1, key);
    }
}
