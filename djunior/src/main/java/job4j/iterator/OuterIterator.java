package job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OuterIterator implements Iterator {

    private Integer index = 0;

    private final Iterator<Integer>[] values;

    public OuterIterator(Iterator<Integer>[] values) {
        this.values = values;
    }


    @Override
    public boolean hasNext() {
        return (values.length > this.index);
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Iterator cur = values[index];
        index++;
        return cur;
    }
}
