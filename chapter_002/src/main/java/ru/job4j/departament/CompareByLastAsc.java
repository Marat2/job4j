package ru.job4j.departament;

import java.util.Comparator;

public class CompareByLastAsc implements Comparator<String> {
    public int compare(String o1, String o2) {
        String[] items1 = o1.split("\\\\");
        String[] items2 = o2.split("\\\\");
        return  items1[items1.length - 1].compareTo(items2[items2.length - 1]);
    }
}
