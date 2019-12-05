package ru.job4j.departament;

import java.util.*;

public class Departure {
    List<String> departament = new ArrayList<>();
    public Departure(List<String> dep) {
        this.departament = dep;
    }

    public List<String> abs(List<String> orgs) {
        Comparator c = Collections.reverseOrder();
        Collections.sort(orgs, new CompareAsc());
        return orgs;
    }
    public List<String> desc(List<String> orgs) {
        Comparator c = Collections.reverseOrder();
        Collections.sort(orgs, new NameCompare().thenComparing(new CompareByLength()).thenComparing(new CompareByLastDesc()));
        return orgs;
    }
    public List<String> fillGaps(List<String> orgs) {
        TreeSet<String> tmpTree = new TreeSet<String>();
        Iterator depiterator = orgs.iterator();
        while (depiterator.hasNext()) {
            String[] items = depiterator.next().toString().split("\\\\");
            String tmp = "";
            for (String item : items) {
                tmp = tmp + "\\" + item;
                tmpTree.add(tmp.substring(1));
            }
        }
        List<String> list = new ArrayList<String>(tmpTree);
        return list;
    }
}
