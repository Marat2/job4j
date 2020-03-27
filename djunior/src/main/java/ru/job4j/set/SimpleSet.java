package ru.job4j.set;

import ru.job4j.dynamic.Dynamic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Iterable<T> {

    Dynamic simpleList = new Dynamic();
    //private int size;

    @Override
    public Iterator<T> iterator() {
        return new IteratorSet();
    }

    public void add(T e) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            T cur = (T) iterator.next();
            if (cur == e) {
                return;
            }

        }

        simpleList.add(e);
        //size++;
    }

    private class IteratorSet implements Iterator<T> {
        public int cursor = 0;

        public IteratorSet() {

        }

        @Override
        public boolean hasNext() {
            return cursor != simpleList.getSize();
        }

        @Override
        public T next() {
            int i = cursor;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return (T) simpleList.get(i);
        }
    }
}
