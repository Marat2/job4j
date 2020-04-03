package ru.job4j.set;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.Consumer;

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
        dynamicArray.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o.toString());
            }
        });
    }
}
