package job4j.customiterator;

import java.util.Iterator;

public class CustomIterator implements Iterator {
    private final int [][] values;

    private int index=0;
    private int inner=0;

    public CustomIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values[index].length>inner;
    }

    @Override
    public Object next() {
        if(hasNext()) {
            return values[index][inner++];
        }else {
            inner=0;
            return values[++index][inner++];
        }
    }
}
