package util;

import java.util.*;

public class ListUtils {

    public static <T extends Comparable<? super T>> boolean isSorted(List<T> list) {
        return isSorted(list, Comparator.naturalOrder());
    }

    public static <T extends Comparable<? super T>> boolean isSorted(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); i++) {
            if (Objects.compare(list.get(i - 1), list.get(i), comparator) > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsAllDistinct(List<?> firstList, List<?> secondList) {
        List<Object> firstListCopy = new ArrayList<>(firstList);
        List<Object> secondListCopy = new ArrayList<>(secondList);
        Iterator<Object> firstI = firstListCopy.iterator();
        while (firstI.hasNext()) {
            Object o1 = firstI.next();
            Iterator secondI = secondListCopy.iterator();
            while (secondI.hasNext()) {
                Object o2 = secondI.next();
                if (Objects.equals(o1, o2)) {
                    firstI.remove();
                    secondI.remove();
                    break;
                }
            }
        }
        return firstListCopy.isEmpty() && secondListCopy.isEmpty();
    }
}
