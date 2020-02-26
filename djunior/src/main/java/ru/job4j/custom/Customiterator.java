package ru.job4j.custom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Customiterator implements Iterator {
    private final int[][] value;

    private int index = 0;
    private int inner = 0;

    public Customiterator(int[][] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return (index < value.length && inner < value[index].length);
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int i = value[index][inner++];
        if (inner == value[index].length) {
            inner = 0;
            index++;
        }
        return i;
    }
}
