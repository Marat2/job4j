package ru.job4j.departament;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DepartamentTest {
    @Test
    //Возможны случаи, когда в массиве отсутствуют строки с кодом верхнеуровнего подразделения
    public void firstTest() {
        List<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        Departure d = new Departure(list);
        List<String> departamentList = d.fillGaps(list);
        System.out.println(d.abs(departamentList).toString());
    }

}
