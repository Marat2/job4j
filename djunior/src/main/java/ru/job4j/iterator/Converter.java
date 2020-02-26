package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> inner;
            private void currentIterator() {
                while (it.hasNext() && (inner == null || !inner.hasNext())) {
                        inner = it.next();
                }
            }
            @Override
            public boolean hasNext() {
                currentIterator();
                return inner.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                //System.out.println("-------"+inner.next());
                return inner.next();
            }
        };
    }
}
