package ru.job4j.store;

import ru.job4j.simplearray.OutOfLimitException;

public interface Store<T extends Base> {

    void add(T model) throws OutOfLimitException;

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}

