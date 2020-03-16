package ru.job4j.simplequeue;

import ru.job4j.dynamiclist.CustomLinked;
import ru.job4j.list.single.IncorrectAction;

public class SimpleQueue<T> {

    private CustomLinked<T> stack = new CustomLinked<T>();

    public T poll() throws IncorrectAction {
        stack.getSize();
        T element = (T) stack.get(stack.getSize() - 1);
        stack.setSize(stack.getSize() - 1);
        return element;
    }

    public void push(T value) {
        stack.add(value);
    }
}
