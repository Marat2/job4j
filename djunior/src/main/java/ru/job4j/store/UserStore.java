package ru.job4j.store;

import ru.job4j.simplearray.SimpleArray;

public class UserStore extends AbstractStore<User> {

    public UserStore(SimpleArray<User> simplearray) {
        super(simplearray);
    }
}