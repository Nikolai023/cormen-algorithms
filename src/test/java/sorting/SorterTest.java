package sorting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static util.ListUtils.containsAllDistinct;
import static util.ListUtils.isSorted;

@RunWith(Parameterized.class)
public class SorterTest {

    private ListSorter sorter;

    public SorterTest(ListSorter sorter) {
        this.sorter = sorter;
    }

    @Parameterized.Parameters
    public static Collection<ListSorter> instancesToTest() {
        return Collections.singletonList(new InsertionSorter());
    }

    @Test
    public void isSortedUnsorted() {
        List<Integer> unsorted = Arrays.asList(1, 2, 4, 3, 5);
        sorter.sort(unsorted);
        Assert.assertTrue(isSorted(unsorted, Comparator.naturalOrder()));
    }

    @Test
    public void isSortedSorted() {
        List<Integer> unsorted = Arrays.asList(1, 2, 3, 4, 5);
        sorter.sort(unsorted);
        Assert.assertTrue(isSorted(unsorted, Comparator.naturalOrder()));
    }

    @Test
    public void isSortedEmpty() {
        List<Integer> unsorted = Collections.emptyList();
        sorter.sort(unsorted);
        Assert.assertTrue(isSorted(unsorted, Comparator.naturalOrder()));
    }

    @Test
    public void resultContainsAllDistinct() {
        List<Integer> unsorted = Arrays.asList(1, 2, 4, 3, 5);
        List<Integer> before = new ArrayList<>(unsorted);
        sorter.sort(unsorted);
        Assert.assertTrue(containsAllDistinct(before, unsorted));
    }
}