package ru.job4j.list.single;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseDeleteFirstAndGetFirstResultTwo() throws IncorrectAction {
        list.delete();
        assertThat(list.get(0), is(2));
    }
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }
}
