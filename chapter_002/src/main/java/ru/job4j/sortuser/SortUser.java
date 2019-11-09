package ru.job4j.sortuser;

import java.util.*;

public class SortUser {

    public Set<User> sort (List<User> users) {
        return new TreeSet<User>(users);
    }

    public List<User> sortNameLength (List<User> users){
        SortedSet<User> usersTree = new TreeSet<User>(this.sort(users));
        Set<User> s = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User s1, User s2) {
                return s1.getName().length()-s2.getName().length();
            }
        });
         s.addAll(usersTree);
        return new ArrayList<User>(s);
    }

    public List<User> sortByAllFields (List<User> users){
        SortedSet<User> usersTree = new TreeSet<User>(this.sort(users));
        Set<User> s = new TreeSet<>(new Comparator<User>() {
            public int compare(User s1, User s2) {
                int NameCompare = s1.getName().compareTo(s2.getName());
                int AgeCompare = s1.getAge()-s2.getAge();
                if (NameCompare == 0) {
                    return ((AgeCompare == 0) ? NameCompare : AgeCompare);
                } else {
                    return NameCompare;
                }
            }
        });
        s.addAll(usersTree);
        return new ArrayList<User>(s);
    }
}
