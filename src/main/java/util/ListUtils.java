package util;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ListUtils {

    public static boolean isSortedNaturalOrder(List<? extends Comparable> list) {
        for (int i = 1; i < list.size(); i++) {
            if (Objects.compare(list.get(i - 1), list.get(i), Comparator.naturalOrder()) > 0) {
                return false;
            }
        }
        return true;
    }
}
