package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Lambda {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i != end; i++) {
            list.add(Math.ceil(func.apply((double) i)));
        }
        return list;
    }
}
