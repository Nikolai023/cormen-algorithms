package search;

import org.junit.Assert;
import org.junit.Test;
import util.RandomListGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BinaryFinderTest {
    @Test
    public void findInList() {
        for (int i = 0; i < 1000; i++) {
            List<Integer> list = RandomListGenerator.generateRandomIntegerList();
            list.sort(Comparator.naturalOrder());
            Finder finder = new BinaryFinder();
            int initialIndex = new Random().nextInt(list.size());
            Integer item = list.get(initialIndex);
            int actualIndex = finder.find(list, item);
            Assert.assertEquals(initialIndex, actualIndex);
        }
    }

}