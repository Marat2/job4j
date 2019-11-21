package ru.job4j.bank;

import java.util.Objects;

public class User implements Comparable<User>  {

    private String name;
    private String passport;

    public User(String passport, String name) {
        this.passport = passport;
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }

    @Override
    public String toString() {
        return "User{"
                +
                "passport="
                + passport
                +
                ", name='"
                + name
                + '\''
                +
                '}';
    }


    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}
