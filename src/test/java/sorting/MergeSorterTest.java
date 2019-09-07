package sorting;

import org.junit.Assert;
import org.junit.Test;
import util.RandomListGenerator;

import java.util.*;

import static util.ListUtils.containsAllDistinct;
import static util.ListUtils.isSorted;

public class MergeSorterTest {
    @Test
    public void mergeTest() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int firstListCapacity = random.nextInt(10);
            List<Integer> firstList = RandomListGenerator.generateRandomIntegerList(firstListCapacity);
            firstList.sort(Comparator.naturalOrder());
            int secondListCapacity = random.nextInt(10);
            List<Integer> secondList = RandomListGenerator.generateRandomIntegerList(secondListCapacity);
            secondList.sort(Comparator.naturalOrder());

            List<Integer> initialList = new ArrayList<>();
            initialList.addAll(firstList);
            initialList.addAll(secondList);
            List<Integer> sortedList = new ArrayList<>(initialList);
            MergeSorter.merge(sortedList, Comparator.naturalOrder(), firstListCapacity - 1);

            Assert.assertTrue(initialList + "\n" + sortedList, isSorted(sortedList));
        }
    }

    @Test
    public void mergeCheckContainsAllDistinct() {
        List<Integer> initialList = Arrays.asList(1, 3, 5, 6, 2, 3, 4, 7);
        List<Integer> sortedList = new ArrayList<>(initialList);

        MergeSorter.merge(sortedList, Comparator.naturalOrder(), 4);

        Assert.assertTrue(containsAllDistinct(initialList, sortedList));
    }
}