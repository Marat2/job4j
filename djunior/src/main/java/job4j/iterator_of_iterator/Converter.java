package job4j.iterator_of_iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> inner;
            int value;
            @Override
            public boolean hasNext() {
                boolean result = true;
                if(inner == null){
                    inner = it.next();
                    result = true;
                }
                if(!inner.hasNext() && !it.hasNext()){
                    result = false;
                }
                while(!inner.hasNext() && it.hasNext()){
                    result = false;
                    inner = it.next();
                    if (inner.hasNext()){
                        result = true;
                    }
                }

                return result;
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
