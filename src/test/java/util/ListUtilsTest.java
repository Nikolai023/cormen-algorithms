package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        Assert.assertFalse(isSorted(unsorted, Comparator.naturalOrder()));
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
}