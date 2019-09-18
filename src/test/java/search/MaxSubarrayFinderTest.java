package search;

import org.junit.Assert;
import org.junit.Test;
import util.ListUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSubarrayFinderTest {
    @Test
    public void findInEmptyList() {
        MaxSubarrayFinder finder = new MaxSubarrayFinder();
        List<Integer> emptyList = Collections.emptyList();

        List<Integer> result = finder.findMaximumSubarray(emptyList);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void findInOneElementList() {
        MaxSubarrayFinder finder = new MaxSubarrayFinder();
        List<Integer> oneElementList = Collections.singletonList(2);

        List<Integer> result = finder.findMaximumSubarray(oneElementList);
        Assert.assertTrue(result.size() == 1 && result.contains(2));
    }

    @Test
    public void findInList() {
        MaxSubarrayFinder finder = new MaxSubarrayFinder();
        List<Integer> oneElementList = Arrays.asList(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7);

        List<Integer> result = finder.findMaximumSubarray(oneElementList);
        Assert.assertTrue(ListUtils.containsAllDistinct(result, Arrays.asList(18, 20, -7, 12)));
    }
}