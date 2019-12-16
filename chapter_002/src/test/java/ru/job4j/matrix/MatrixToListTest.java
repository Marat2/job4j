package ru.job4j.matrix;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void getAddressList() {

        List<Integer> expected = List.of(1, 2, 3, 4);

        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        MatrixToList convert = new MatrixToList();
        assertThat(expected, is(convert.matrixTolist(matrix)));
    }
}
