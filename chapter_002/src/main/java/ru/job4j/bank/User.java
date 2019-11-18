package ru.job4j.bank;

import java.util.Objects;

public class User implements Comparable<User>  {

    private String name;
    private String passport;

    User(String passport){
        this.passport = passport;
    }

    User(String passport, String name){
        this.passport = passport;
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
    @Override
    public boolean equals(Object o) {
        return this.passport.equals(((User) o).passport);
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
    //по идее у пользователей должны быть разные паспортные данные поэтому я для улучшения производительности решил
    //в качестве хеша ис-ть серию паспорта.
    @Override
    public int hashCode() {
        return  Objects.hash(this.passport);
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
}
