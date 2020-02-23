package job4j.iteratorOfiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> inner;
            private void CurrentIterator() {
                while (it.hasNext()) {
                    if (inner != null &&  inner.hasNext()) {
                        break;
                    }
                }
            }
            @Override
            public boolean hasNext() {
                CurrentIterator();
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
