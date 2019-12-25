package ru.job4j.search;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void compareLists() {
        PriorityQueue queue = new PriorityQueue();
        Task first = new Task("urgent", 1);
        Task second = new Task("middle", 3);
        Task third = new Task("low", 5);
        List<Task> expected = List.of(first, second, third);

        queue.put(third);
        queue.put(first);
        queue.put(second);
        LinkedList<Task> result = queue.getTasks();
        assertThat(expected, is(result));
    }
}
