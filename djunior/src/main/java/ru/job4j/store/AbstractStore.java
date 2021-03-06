package ru.job4j.store;

import ru.job4j.simplearray.OutOfLimitException;
import ru.job4j.simplearray.SimpleArray;

abstract class AbstractStore<T extends Base> implements Store<T> {

    protected SimpleArray<T> sa;

    public AbstractStore(SimpleArray<T> simplearray) {
        sa = simplearray;
    }

    public void add(T model) throws OutOfLimitException {
        sa.add(model);
    }

    public boolean replace(String id, T model) {
        sa.result[findElement(id)] = model;
        return true;
    }

    public boolean delete(String id) {
        sa.remove(findElement(id));
        return true;
    }

    public T findById(String id) {
        return (T) sa.result[findElement(id)];
    }

    protected int findElement(String id) {
        for (int i = 0; i < sa.size(); i++) {
            T role = (T) sa.result[i];
            if (role.getId().equals(id)) {
                return i;
            }
        }
        //throw new NoSuchElementException();
        return -1;
    }
}
