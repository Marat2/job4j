package ru.job4j.map;

import java.util.Calendar;

public class User {

    private String name;
    private int children;
    private Calendar birthday;
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /*@Override
    public String toString() {
        return " Name: "+this.name+" children: "+this.children+" birthday: "+this.birthday.getWeekYear();
    }*/
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        User other = (User) obj;
        return this.name.equals(other.name);
    }
}
