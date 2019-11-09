package ru.job4j.sortuser;

import java.util.*;

public class SortUser {

    public Set<User> sort (List<User> users) {
        SortedSet<User> usersTree = new TreeSet<>();
        usersTree.addAll(users);
        return usersTree;
    }
/*
    public List<User> sortByAllFields (List<User> users){
        SortedSet<User> usersTree = new TreeSet<>();
        usersTree.addAll(users);
        List<User> result = new ArrayList<>();
        result.addAll(usersTree);
        return result;
    }

    public List<User> sortNameLength (List<User> users){
        SortedSet<User> usersTree = new TreeSet<>();
        usersTree.addAll(users);
        List<User> result = new ArrayList<>();
        result.addAll(usersTree);
        return result;
    }*/
}
