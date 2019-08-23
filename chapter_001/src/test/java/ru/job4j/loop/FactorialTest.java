package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class FactorialTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Factorial fack = new Factorial();
        int expected = 120;
        int result = fack.calc(5);
        assertThat(result, is(expected));
    }
}
