package ru.job4j.dynamic;

import java.util.*;

public class Dynamic<E> implements Iterable<E> {

    private static Object[] arrayStore = {};

    private int size;

    private int expectedModCount;
    private int modCount = 0;
    Dynamic() {
        arrayStore = new Object[0];
    }
    @Override
    public Iterator<E> iterator() {
        return new IteratorOfDynamic();
    }

    public void add(E value) {
        arrayStore = grow();
        incrementOperation();
        arrayStore[arrayStore.length - 1] = value;
    }
    public E get(int index) {
        if (index > 0 && index < arrayStore.length) {
            return (E) arrayStore[index];
        }
        throw new NoSuchElementException();
    }
    private void incrementOperation() {
        this.modCount++;
    }
    private Object[] grow() {
        size++;
        arrayStore = Arrays.copyOf(arrayStore, arrayStore.length + 1);
        return  arrayStore;
    }
    private void checkForComodification(int expectedModCount) {
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
    private class IteratorOfDynamic implements Iterator<E> {
        int cursor;
        int expectedModCount = modCount;
        IteratorOfDynamic() {

        }
        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkForComodification(expectedModCount);
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            if (i >= arrayStore.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            return (E) arrayStore[i];
        }
    }
}
