package ru.job4j.even;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    public final int[] incomingArgs;
    private int index = 0;

    public EvenIterator(int[] incomingArgs) {
        this.incomingArgs = incomingArgs;
    }

    private boolean validate(int number) {
        boolean result = true;
        if (number % 2 != 0) {
            index++;
            result = false;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i <= incomingArgs.length - 1; i++) {
            if (validate(incomingArgs[index])) {
                result = true;
                break;
            }
        }
        return result;
    }
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return  incomingArgs[index++];
    }
}
