package search;

import org.junit.Assert;
import org.junit.Test;
import util.RandomListGenerator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BinaryFinderTest {
    @Test
    public void findInList() {
        RandomListGenerator generator = new RandomListGenerator();
        for (int i = 0; i < 1000; i++) {
            List<Integer> list = generator.generate();
            list.sort(Comparator.naturalOrder());
            Finder finder = new BinaryFinder();
            int initialIndex = new Random().nextInt(list.size());
            Integer item = list.get(initialIndex);
            int actualIndex = finder.find(list, item);
            Assert.assertEquals(
                    "List:" + list + "\n" +
                            "Expected index: " + initialIndex + "\n" +
                            "Actual index: " + actualIndex + "\n",
                    initialIndex,
                    actualIndex);
        }
    }

    @Test
    public void findInEmptyList() {
        List<Integer> list = Collections.emptyList();
        Finder finder = new BinaryFinder();
        Assert.assertEquals(-1, finder.find(list, 1));
    }

}