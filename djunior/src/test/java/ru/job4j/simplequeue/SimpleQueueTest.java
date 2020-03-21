package ru.job4j.simplequeue;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.list.single.IncorrectAction;

public class SimpleQueueTest {
    public SimpleQueue queue = new SimpleQueue();

    @Before
    public void setUp() {
        queue.push("test1");
        queue.push("test2");
        queue.push("test3");
    }

    @Test
    public void test() throws IncorrectAction {
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
