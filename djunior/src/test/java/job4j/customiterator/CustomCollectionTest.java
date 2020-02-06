package job4j.customiterator;

import job4j.customiterator.CustomCollection;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class CustomCollectionTest {
    @Test
    public void addUserTest() {
        int[][] value = {
                {1, 2,5},
                {3, 4}
        };
        CustomCollection test = new CustomCollection(value);
        Iterator iterator = test.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
