package ru.job4j.stack;

import org.junit.Test;
import ru.job4j.list.single.IncorrectAction;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
public class SimpleStackTest {

    @Test
    public void whenPushThenPoll() throws IncorrectAction {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.poll(), is(1));
    }

    @Test
    public void whenPushPollThenPushPoll() throws IncorrectAction {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.poll();
        stack.push(2);
        assertThat(stack.poll(), is(2));
    }

    @Test
    public void whenPushPushThenPollPoll() throws IncorrectAction {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.poll();
        assertThat(stack.poll(), is(1));
    }
}
