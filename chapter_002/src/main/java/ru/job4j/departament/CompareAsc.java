package ru.job4j.departament;

import java.util.Comparator;

public class CompareAsc implements Comparator<String> {
    public int compare(String o1, String o2) {
        String[] items1 = o1.split("\\\\");
        String[] items2 = o2.split("\\\\");
        return  items1[0].compareTo(items2[0]);
    }
}
