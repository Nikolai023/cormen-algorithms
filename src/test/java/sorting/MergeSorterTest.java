package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.ListUtils.containsAllDistinct;
import static util.ListUtils.isSorted;

public class MergeSorterTest {
    @Test
    public void mergeTest() {
        List<Integer> initialList = Arrays.asList(1, 3, 5, 6, 2, 3, 4, 7);

        MergeSorter.merge(initialList, 4);

        Assert.assertTrue(isSorted(initialList));
    }

    @Test(expected = AssertionError.class)
    public void mergeExceptionTest() {
        List<Integer> initialList = Arrays.asList(1, 3, 5, 6, 2, 3, 4, 7);
        MergeSorter.merge(initialList, 20);
    }

    @Test
    public void mergeCheckContainsAllDistinct() {
        List<Integer> initialList = Arrays.asList(1, 3, 5, 6, 2, 3, 4, 7);
        List<Integer> sortedList = new ArrayList<>(initialList);

        MergeSorter.merge(sortedList, 4);

        Assert.assertTrue(containsAllDistinct(initialList, sortedList));
    }
}