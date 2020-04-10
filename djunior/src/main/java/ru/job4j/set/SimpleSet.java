package ru.job4j.set;

import ru.job4j.dynamic.Dynamic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SimpleSet<T> implements Iterable {

    Dynamic simpleList = new Dynamic();

    @Override
    public Iterator<T> iterator() {
        return simpleList.iterator();
    }

    public void add(T e) {
        if (!contains(e)) {
            simpleList.add(e);
        }
    }
    public boolean contains(T e) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            T cur = (T) iterator.next();
            if (cur.equals(e) ) {
                return true;
            }
        }
        return false;
    }
}
