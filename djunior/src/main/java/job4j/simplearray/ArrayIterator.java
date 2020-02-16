package job4j.simplearray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator {

    private final SimpleArray<T> values;
    private int index = 0;

    public ArrayIterator(SimpleArray<T> values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return (values.result.length>index);
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values.result[index++];
    }
}
