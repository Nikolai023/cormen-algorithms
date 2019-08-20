package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static util.ListUtils.containsAllDistinct;
import static util.ListUtils.isSorted;

public class InsertionSorterTest {

    @Test
    public void isSortedUnsorted() {
        List<Integer> unsorted = Arrays.asList(1, 2, 4, 3, 5);
        ListSorter sorter = new InsertionSorter();
        sorter.sort(unsorted);
        Assert.assertTrue(isSorted(unsorted, Comparator.naturalOrder()));
    }

    @Test
    public void isSortedSorted() {
        List<Integer> unsorted = Arrays.asList(1, 2, 3, 4, 5);
        ListSorter sorter = new InsertionSorter();
        sorter.sort(unsorted);
        Assert.assertTrue(isSorted(unsorted, Comparator.naturalOrder()));
    }

    @Test
    public void isSortedEmpty() {
        List<Integer> unsorted = Collections.emptyList();
        ListSorter sorter = new InsertionSorter();
        sorter.sort(unsorted);
        Assert.assertTrue(isSorted(unsorted, Comparator.naturalOrder()));
    }

    @Test
    public void resultContainsAllDistinct() {
        List<Integer> unsorted = Arrays.asList(1, 2, 4, 3, 5);
        List<Integer> before = new ArrayList<>(unsorted);
        ListSorter sorter = new InsertionSorter();
        sorter.sort(unsorted);
        Assert.assertTrue(containsAllDistinct(before, unsorted));
    }
}