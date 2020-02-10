package job4j.eveniterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    public final int[] incoming_args;
    private int index=0;

    public EvenIterator(int[] incoming_args) {
        this.incoming_args = incoming_args;
    }
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (incoming_args.length<=index || incoming_args.length==1) {
            result = false;
        }else {
            while (incoming_args.length<=this.index || incoming_args[this.index]%2!=0) {
                this.index++;
                if(this.index>incoming_args.length){
                    throw new NoSuchElementException();
                }
            }
            if (this.index>=incoming_args.length) {
                result = false;
            } else {
                result = true;
            }
            result = true;
        }
        return result;
    }
    @Override
    public Object next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        int i = incoming_args[index];
        index++;
        return  i;
    }
}
