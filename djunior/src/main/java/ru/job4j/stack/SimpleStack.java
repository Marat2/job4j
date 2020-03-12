package ru.job4j.stack;

import ru.job4j.dynamiclist.CustomLinked;
import ru.job4j.list.single.IncorrectAction;

public class SimpleStack<T> {
    private CustomLinked<T> linked = new CustomLinked<T>();

    public T poll() throws IncorrectAction {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }
}
