package job4j.iterator_of_iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> inner = it.next();
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (inner.hasNext()){
                    result = true;
                }else {
                    if (it.hasNext()){
                        inner=it.next();
                        result = true;
                        while (!inner.hasNext() && it.hasNext()){
                            it.next();
                            result = false;
                        }
                    }else {
                        result=false;
                    }
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return inner.next();
            }
        };
    }
}
