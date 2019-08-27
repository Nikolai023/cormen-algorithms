package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorter implements ListSorter {
    protected static <T extends Comparable<? super T>> void merge(List<T> list, int q) {
        merge(list, 0, q, list.size() - 1);
    }

    private static <T extends Comparable<? super T>> void merge(List<T> A, int p, int q, int r) {
        if (q == r) {
            return;
        }

        int n1 = q - p + 1;
        int n2 = r - q;

        List<T> L = new ArrayList<>(n1);
        List<T> R = new ArrayList<>(n2);
        for (int i = 0; i < n1; i++) {
            L.add(i, A.get(p + i));
        }
        for (int j = 0; j < n2; j++) {
            R.add(j, A.get(q + j + 1));
        }

        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (i < L.size() && (j >= R.size() || L.get(i).compareTo(R.get(j)) <= 0)) {
                A.set(k, L.get(i));
                i++;
            } else {
                A.set(k, R.get(j));
                j++;
            }
        }
    }

    private static <T extends Comparable<? super T>> void mergeSort(List<T> A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list, Comparator<T> comparator) {
        mergeSort(list, 0, list.size() - 1);
    }

}
