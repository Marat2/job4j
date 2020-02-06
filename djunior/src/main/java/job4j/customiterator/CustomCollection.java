package job4j.customiterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomCollection implements Iterable{

    private final int[][] values;

    public CustomCollection(int[][] values) {
        this.values = values;
    }

    @Override
    public Iterator iterator() {
        return new CustomIterator(this.values);
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
