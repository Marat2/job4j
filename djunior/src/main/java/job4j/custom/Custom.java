package job4j.custom;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Custom implements Iterable {

    private final int[][] values;

    public Custom(int[][] values) {
        this.values = values;
    }

    @Override
    public Iterator iterator() {
        return new Customiterator(this.values);
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
