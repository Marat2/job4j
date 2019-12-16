package ru.job4j.matrix;

import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public List<Integer> matrixTolist(List<List<Integer>> matrix) {
        List<Integer> list = matrix.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
        return list;
    }
}
