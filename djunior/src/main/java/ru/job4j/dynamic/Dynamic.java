package ru.job4j.dynamic;

import java.util.*;

public class Dynamic<E> implements Iterable<E> {

    private static Object[] arrayStore = {};
    private int defSize = 10;
    private int size;

    private int expectedModCount;
    private int modCount;
    Dynamic() {
        arrayStore = new Object[defSize];
    }
    @Override
    public Iterator<E> iterator() {
        return new IteratorOfDynamic();
    }

    public void add(E value) {
        int i = size;
        arrayStore = grow();
        incrementOperation();
        arrayStore[i] = value;
    }
    public E get(int index) {
        if (index > 0 && index < size) {
            return (E) arrayStore[index];
        }
        throw new NoSuchElementException();
    }
    private void incrementOperation() {
        this.modCount++;
    }
    private Object[] grow() {
        if (size >= arrayStore.length) {
            arrayStore = Arrays.copyOf(arrayStore, arrayStore.length + defSize);
        }
        size++;
        return  arrayStore;
    }

    private class IteratorOfDynamic implements Iterator<E> {
        int cursor = 0;
        int expectedModCount = modCount;
        IteratorOfDynamic() {

        }
        private void checkForComodification(int expectedModCount) {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkForComodification(expectedModCount);
            int i = cursor;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return (E) arrayStore[i];
        }
    }
}
