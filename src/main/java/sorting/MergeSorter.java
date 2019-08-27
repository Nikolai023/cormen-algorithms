package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorter implements ListSorter {
    protected static <T extends Comparable<? super T>> void merge(List<T> list, int q) {
        assert q > 0 && q < list.size();
        merge(list, 0, q, list.size() - 1);
    }

    private static <T extends Comparable<? super T>> void merge(List<T> A, int p, int q, int r) {
        int n1 = q - p;
        int n2 = r - q + 1;

        List<T> L = new ArrayList<>(n1);
        List<T> R = new ArrayList<>(n2);
        for (int i = 0; i < n1; i++) {
            L.add(i, A.get(p + i));
        }
        for (int j = 0; j < n1; j++) {
            R.add(j, A.get(q + j));
        }

        int i = 0;
        int j = 0;
        for (int k = p; k < r; k++) {
            if (L.get(i).compareTo(R.get(j)) < 0) {
                A.set(k, L.get(i));
                i++;
            } else {
                A.set(k, R.get(j));
                j++;
            }
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list, Comparator<T> comparator) {

    }

}
