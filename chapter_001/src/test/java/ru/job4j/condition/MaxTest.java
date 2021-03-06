package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class MaxTest {
    @Test
    public void seconGreaterThenFirst() {
        Max max = new Max();
        int result = max.max(2, 3);
        assertThat(result, is(3));
    }
    @Test
    public void firstGreaterThenSecond() {
        Max max = new Max();
        int result = max.max(3, 2);
        assertThat(result, is(3));
    }
    @Test
    public void bothEquals() {
        Max max = new Max();
        int result = max.max(3, 3);
        assertThat(result, is(3));
    }
}
