package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static util.ListUtils.isSortedNaturalOrder;

public class ListUtilsTest {

    @Test
    public void isSortedSortedList() {
        List<Integer> sorted = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertTrue(isSortedNaturalOrder(sorted));
    }

    @Test
    public void isSortedUnsortedList() {
        List<Integer> unsorted = Arrays.asList(1, 2, 4, 3, 5);
        Assert.assertFalse(isSortedNaturalOrder(unsorted));
    }

    @Test
    public void isSortedSortedListWithDuplicateValues() {
        List<Integer> sortedWithDuplicates = Arrays.asList(1, 2, 2, 3, 5);
        Assert.assertTrue(isSortedNaturalOrder(sortedWithDuplicates));
    }
}