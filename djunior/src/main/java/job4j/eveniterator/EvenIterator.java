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
        boolean result=false;
        for (int i = index; i <= incomingArgs.length-1; i++) {
            if(index>incomingArgs.length){
                throw new NoSuchElementException();
            }else if (incomingArgs[index]%2!=0){
                index++;
            }else{
                result = true;
                break;
            }
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
