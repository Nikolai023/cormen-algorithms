package sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static util.ListUtils.isSorted;

@RunWith(Parameterized.class)
public class SorterSimpleTest {

    private ListSorter sorter;

    public SorterSimpleTest(ListSorter sorter) {
        this.sorter = sorter;
    }

    @Parameterized.Parameters
    public static Collection<ListSorter> instancesToTest() {
        return ListSorter.allSortersList();
    }

    @Test
    public void isSortedSorted() {
        List<Integer> unsorted = Arrays.asList(1, 2, 3, 4, 5);
        sorter.sort(unsorted);
        Assert.assertTrue(isSorted(unsorted));
    }

    @Test
    public void isSortedEmpty() {
        List<Integer> unsorted = Collections.emptyList();
        sorter.sort(unsorted);
        Assert.assertTrue(isSorted(unsorted));
    }
}