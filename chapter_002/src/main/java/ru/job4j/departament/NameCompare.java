package ru.job4j.departament;

import java.util.Comparator;
public class NameCompare implements Comparator<String> {
    public int compare(String o1, String o2) {
        String[] items1 = o1.split("\\\\");
        String[] items2 = o2.split("\\\\");
        return  items2[0].compareTo(items1[0]);
    }
    //[K2, K2\SK1, K2\SK1\SSK1, K2\SK1\SSK2, K1, K1\SK1, K1\SK2, K1\SK1\SSK1, K1\SK1\SSK2]
}
