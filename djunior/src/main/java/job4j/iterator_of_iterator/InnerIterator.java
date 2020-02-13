package job4j.iterator_of_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class InnerIterator implements Iterator {

    private final Integer[] values;

    private int index = 0;

    public InnerIterator(Integer[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return (values.length>this.index);
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int cur = values[index];
        index++;
        return cur;
    }
}
