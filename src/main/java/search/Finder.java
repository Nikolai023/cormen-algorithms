package search;

import java.util.List;

public interface Finder {
    <T extends Comparable<? super T>> int find(List<T> list, T item) ;
}
