package job4j.customiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator implements Iterator {
    private final int [][] value;

    int index = 0;
    int inner = 0;

    public CustomIterator(int[][] value) {
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
