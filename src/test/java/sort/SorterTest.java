package sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.RandomListGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

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

        List<ListSorter> sorters = ListSorter.allSortersList();

        List<List<Integer>> lists = new ArrayList<>();
        RandomListGenerator generator = new RandomListGenerator();
        for (int i = 0; i < 100; i++) {
            lists.add(generator.generate());
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
    public void resultContainsAllDistinct() {
        List<Integer> actual = getListForTest();
        sorter.sort(actual);
        Assert.assertTrue(getErrorMessage(actual), containsAllDistinct(list, actual));
    }

    @Test
    public void sortWithNondefaultComparator() {
        List<Integer> actual = getListForTest();
        Comparator<Integer> comparator = Comparator.reverseOrder();
        sorter.sort(actual, comparator);
        Assert.assertTrue(getErrorMessage(actual), isSorted(actual, comparator));
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