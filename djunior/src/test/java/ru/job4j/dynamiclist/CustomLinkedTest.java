package ru.job4j.dynamiclist;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CustomLinkedTest {
    private CustomLinked<String> linkedlist;
    @Before
    public void beforeTest() {
        linkedlist = new CustomLinked<>();
        linkedlist.add("test5");
        linkedlist.add("test4");
        linkedlist.add("test3");
    }

    @Test
    public void whenAddThreeElementsThenUseDeleteFirstAndGetFirstResultTwo() {
        Iterator<String> linkedIterator = linkedlist.iterator();
        assertThat(linkedIterator.next(), is("test5"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        Iterator<String> linkedIterator =  linkedlist.iterator();
        linkedlist.add("test4");
        assertThat(linkedIterator.next(), is("test5"));
    }
}
