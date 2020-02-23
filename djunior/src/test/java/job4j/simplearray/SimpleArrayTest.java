package job4j.simplearray;

import org.junit.Test;
import org.junit.matchers.*;
import org.junit.Before;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class SimpleArrayTest {

    ArrayIterator<String> it;

    @Before
    public void setUp() throws OutOfLimitException {
        SimpleArray<String> array = new SimpleArray<String>(4);
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("four");
        it = new ArrayIterator(array);
    }

    @Test
    public void test() {
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}
