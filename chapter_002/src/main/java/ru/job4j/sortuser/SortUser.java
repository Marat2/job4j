package ru.job4j.sortuser;

import java.util.*;

public class SortUser {

    public Set<User> sort (List<User> users) {
        return new TreeSet<User>(users);
    }

    public List<User> sortNameLength (List<User> users){
        users.sort(Comparator.comparingInt(o->o.getName().length()));
        return users;
    }

    public List<User> sortByAllFields (List<User> users){
        users.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));
        return users;
    }
}
