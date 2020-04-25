package ru.job4j.set;

import ru.job4j.dynamic.Dynamic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SimpleSet<T> implements Iterable {

    private Dynamic simpleList = new Dynamic();

    public boolean result = false;

    @Override
    public Iterator<T> iterator() {
        return simpleList.iterator();
    }

    public void add(T e) {
        contains(e);
        if (!result) {
            simpleList.add(e);
        }
    }

    public void contains(T e) {
        iterator().forEachRemaining(s-> {
            if (s.equals(e)) {
                 this.result = true;
            }
        });
    }
}
