package ru.job4j.store;

import ru.job4j.simplearray.SimpleArray;

public class UserStore<T extends User> extends AbstractStore {

    public UserStore(SimpleArray<User> simplearray) {
        super(simplearray);
    }
}