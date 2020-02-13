package job4j.eveniterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    public final int[] incomingArgs;
    private int index=0;

    public EvenIterator(int[] incomingArgs) {
        this.incomingArgs = incomingArgs;
    }
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (incomingArgs.length<=index || incomingArgs.length==1) {
            result = false;
        }else {
            while (incomingArgs.length<=index || incomingArgs[index]%2!=0) {
                index++;
                if(index>incomingArgs.length){
                    throw new NoSuchElementException();
                }
            }
            if (index>=incomingArgs.length) {
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
        int i = incomingArgs[index++];
        return  i;
    }
}
