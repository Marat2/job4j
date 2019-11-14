package ru.job4j.review;


import ru.job4j.sortuser.User;

import java.util.*;
//нет класса User
public class Sorter {
    //зачем тут нужен конструктор в таком виде лучше убрать
    public Sorter(){

    }

    Set<User> sort (List<User> list) {//можно сразу отправить list в treeset
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }

    List<User> sortnamelength (List<User> list) {//здесь бы лучше ис-ть кострукцию типа list.sort(Comporator.comparingInt(o->o.getName.length()))
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }

    List<User> sortboth (List<User> list) {//здесь бы лучше ис-ть кострукцию типа list.sort(Comporator.comparing(o->o.getName()).thenComparing(o->o.getAge()))
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}