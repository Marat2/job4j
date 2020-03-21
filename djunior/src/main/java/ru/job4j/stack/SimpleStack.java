package ru.job4j.stack;

import ru.job4j.dynamiclist.CustomLinked;
import ru.job4j.list.single.IncorrectAction;

public class SimpleStack<T> {
    private CustomLinked<T> linked = new CustomLinked<T>();

    private int size;

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T poll() throws IncorrectAction {
        T last = linked.deleteLast();
        this.size = linked.getSize();
        return last;
    }

    public void push(T value) {
        linked.add(value);
        this.size = linked.getSize();
    }
}
