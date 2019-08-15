package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
public class SqAreaTest {
    @Test
    public void fourd() {
        int expected = 4;
        int s = SqMax.max(1, 2,3,4);
        assertThat(s, is(expected));
    }

    @Test
    public void third() {
        int expected = 4;
        int s = SqMax.max(2,3,4,1);
        assertThat(s, is(expected));
    }
    @Test
    public void second() {
        int expected =4;
        int s = SqMax.max(3,4,1,2);
        assertThat(s, is(expected));
    }

    @Test
    public void first() {
        int expected =4;
        int s = SqMax.max(4,1,2,3);
        assertThat(s, is(expected));
    }
    @Test
    public void whenThirdLargerFirst(){
        int expected =5;
        int s = SqMax.max(4, 3, 5,1);
        assertThat(s, is(expected));
    }
}
