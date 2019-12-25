package ru.job4j.departament;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DepartamentTest {
    @Test
    //Возможны случаи, когда в массиве отсутствуют строки с кодом верхнеуровнего подразделения
    public void firstTest() {
        List<String> list = List.of("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2");
        Departure d = new Departure(list);
        List<String> departamentList = d.fillGaps(list);
        System.out.println(d.abs(departamentList).toString());
    }

}
