package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static util.ListUtils.containsAllDistinct;
import static util.ListUtils.isSorted;

public class ListUtilsTest {

    @Test
    public void isSortedSortedList() {
        List<Integer> sorted = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertTrue(isSorted(sorted, Comparator.naturalOrder()));
    }

    @Test
    public void isSortedUnsortedList() {
        List<Integer> unsorted = Arrays.asList(1, 2, 4, 3, 5);
        Assert.assertFalse(isSorted(unsorted));
    }

    @Test
    public void isSortedSortedListWithDuplicateValues() {
        List<Integer> sortedWithDuplicates = Arrays.asList(1, 2, 2, 3, 5);
        Assert.assertTrue(isSorted(sortedWithDuplicates, Comparator.naturalOrder()));
    }

    @Test
    public void isSortedSingleElementList() {
        List<Integer> singleElementList = Collections.singletonList(1);
        Assert.assertTrue(isSorted(singleElementList, Comparator.naturalOrder()));
    }

    @Test
    public void isSortedEmptyList() {
        List<Integer> emptyList = Collections.emptyList();
        Assert.assertTrue(isSorted(emptyList, Comparator.naturalOrder()));
    }

    @Test
    public void containsAllContainsAll() {
        List<Object> first = Arrays.asList(1, 2, 3, 4, 5);
        List<Object> second = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertTrue(containsAllDistinct(first, second));
    }

    @Test
    public void containsAllNotContainsAll() {
        List<Object> first = Arrays.asList(1, 2, 3, 4, 5);
        List<Object> second = Arrays.asList(1, 4, 5);
        Assert.assertFalse(containsAllDistinct(first, second));
    }

    @Test
    public void containsAllEmpty() {
        List<Object> first = Collections.emptyList();
        List<Object> second = Collections.emptyList();
        Assert.assertTrue(containsAllDistinct(first, second));
    }
}