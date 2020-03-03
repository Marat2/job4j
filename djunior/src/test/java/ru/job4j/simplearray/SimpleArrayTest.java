package ru.job4j.simplearray;

import org.junit.Test;
import org.junit.Before;

public class SimpleArrayTest {

    ArrayIterator<String> it;

    @Before
    public void setUp() throws OutOfLimitException {
        SimpleArray<String> array = new SimpleArray<String>(4);
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("four");
        array.remove(2);
        it = new ArrayIterator(array);
    }

    @Test
    public void test() {
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        //System.out.println(it.next());
    }

}
