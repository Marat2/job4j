package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
public class LambdaTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Lambda l = new Lambda();
        List<Double> result = l.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSqFunctionThenSqResults() {
        Lambda l = new Lambda();
        List<Double> result = l.diapason(1, 7, x -> Math.log(x));
        List<Double> expected = Arrays.asList(0D, 1D, 2D, 2D, 2D, 2D);
        assertThat(result, is(expected));
    }
}
