package ru.job4j.set;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    SimpleSet dynamicArray = new SimpleSet();
    @Before
    public void setUp() {
        dynamicArray.add("test1");
        dynamicArray.add("test2");
        dynamicArray.add("test3");
        dynamicArray.add("test3");
    }

    @Test
    public void testForiterator() {
        Iterator<String> dynamicIterator =  dynamicArray.iterator();
        System.out.println(dynamicIterator.next());
        System.out.println(dynamicIterator.next());
        System.out.println(dynamicIterator.next());
        System.out.println(dynamicIterator.next());
        //assertThat(dynamicIterator.next(), is("test1"));
    }
}
