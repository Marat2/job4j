package ru.job4j.dynamiclist;

import ru.job4j.dynamic.Dynamic;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinked<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    private int modCount;

    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }
    public int getSize() {
        return this.size;
    }
    @Override
    public Iterator<E> iterator() {
        return new IteratorOfDynamic();
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private class IteratorOfDynamic implements Iterator<E> {
        int cursor = size - 1;
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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = cursor;
            cursor--;
            return get(i);
        }
    }
}
