package ru.job4j.store;

import ru.job4j.simplearray.OutOfLimitException;
import ru.job4j.simplearray.SimpleArray;

public class UserStore<T extends User> extends AbstractStore implements Store<User> {

    public UserStore(SimpleArray<User> simplearray) {
        super(simplearray);
    }

    @Override
    public void add(User model) throws OutOfLimitException {
        sa.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        boolean result = false;
        if (findElement(id)) {
            sa.result[ArrayIndex] = model;
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        if (findElement(id)) {
            sa.remove(ArrayIndex);
            result = true;
        }
        return result;
    }

    @Override
    public User findById(String id) {
        User result = new User("0");
        if (findElement(id)) {
            result = (User) sa.result[ArrayIndex];
        }
        return result;
    }
}