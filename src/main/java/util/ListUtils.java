package util;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ListUtils {

    public static <T extends Comparable> boolean isSorted(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            if (Objects.compare(list.get(i - 1), list.get(i), comparator) > 0) {
                return false;
            }
        }
        return true;
    }
}
