package ru.job4j.bank;

import java.util.Objects;

public class User implements Comparable<User>  {
    @Override
    public int compareTo(User o) {
        return 0;
    }
    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
