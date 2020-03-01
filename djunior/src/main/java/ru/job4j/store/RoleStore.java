package ru.job4j.store;

import ru.job4j.simplearray.SimpleArray;

public class RoleStore<T extends Role> extends AbstractStore {

    public RoleStore(SimpleArray<Role> simplearray) {
        super(simplearray);
    }
}