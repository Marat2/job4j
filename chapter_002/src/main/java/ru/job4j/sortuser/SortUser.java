package ru.job4j.sortuser;

import java.util.*;

public class SortUser {
    public Set<User> sort (List<User> users){
        SortedSet<User> usersTree = new TreeSet<>(Comparator.comparing(User::getAge));
        usersTree.addAll(users);
        return usersTree;
    }
}
