package sort;

import java.util.Comparator;
import java.util.List;

public class SelectionSorter implements ListSorter {

    public SelectionSorter() {
    }

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list, Comparator<T> comparator) {
        for (int j = 0; j < list.size(); j++) {
            int minIndex = j;
            T min = list.get(j);

            for (int i = j + 1; i < list.size(); i++) {
                T current = list.get(i);
                if (comparator.compare(min, current) > 0) {
                    minIndex = i;
                    min = current;
                }
            }

            if (minIndex != j) {
                list.set(minIndex, list.get(j));
                list.set(j, min);
            }
        }
    }
}
