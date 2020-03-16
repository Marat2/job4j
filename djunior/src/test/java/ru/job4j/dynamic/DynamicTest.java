package ru.job4j.dynamic;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicTest {
    Dynamic dynamicArray = new Dynamic();
    @Before
    public void setUp() {
        dynamicArray.add("test1");
        dynamicArray.add("test2");
        dynamicArray.add("test3");

    }
    @Test
    public void testForiterator() {
        Iterator<String> dynamicIterator =  dynamicArray.iterator();
        System.out.println(dynamicArray.get(0) + "" + dynamicArray.get(1) + "" + dynamicArray.get(2));
        assertThat(dynamicIterator.next(), is("test1"));
    }
    @Test(expected = ConcurrentModificationException.class)
    public void hasNextShouldReturnFalseInCaseOfEmptyIterators() {
        Iterator<String> dynamicIterator =  dynamicArray.iterator();
        dynamicArray.add("test4");
        assertThat(dynamicIterator.next(), is("test1"));
    }
}
