package sorting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.RandomListGenerator;

import java.util.*;

import static util.ListUtils.containsAllDistinct;
import static util.ListUtils.isSorted;

@RunWith(Parameterized.class)
public class SorterTest {

    private ListSorter sorter;
    private List<Integer> list;

    public SorterTest(ListSorter sorter, List<Integer> list) {
        this.sorter = sorter;
        this.list = list;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        Collection<Object[]> instances = new ArrayList<>();

        List<ListSorter> sorters = Arrays.asList(
                new InsertionSorter(),
                new SelectionSorter()
/*
                ,
                new MergeSorter()
*/
        );

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lists.add(RandomListGenerator.generateRandomIntegerList());
        }

        for (ListSorter sorter : sorters) {
            for (List<Integer> list : lists) {
                instances.add(new Object[]{sorter, list});
            }
        }

        return instances;
    }

    @Test
    public void isSortedUnsorted() {
        List<Integer> actual = getListForTest();
        sorter.sort(actual);
        Assert.assertTrue(getErrorMessage(actual), isSorted(actual));
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

    @Test
    public void resultContainsAllDistinct() {
        List<Integer> actual = getListForTest();
        sorter.sort(actual);
        Assert.assertTrue(getErrorMessage(actual), containsAllDistinct(list, actual));
    }

    private List<Integer> getListForTest() {
        return new ArrayList<>(list);
    }

    private String getErrorMessage(List<Integer> actual) {
        return "Sorter: " + sorter + ";\n" +
                "Initial: " + list + ";\n" +
                "Actual: " + actual + ";\n";
    }
}