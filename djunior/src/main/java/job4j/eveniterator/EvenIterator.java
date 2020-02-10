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
    //2 случая  - если последний элемент четный и если последний элемент не четный. (2,4,6,8 и 1,2,3,4,5,6,7)
    public boolean hasNext() {
        boolean result = false;
        int i = this.index;
        if (incoming_args.length<=index || incoming_args.length==1) {
            result = false;
        }else {
            while (incoming_args.length<=i || incoming_args[i]%2!=0) {//пребавляю пока не найду четный или не выйду за предел
                i++;
                if(i>incoming_args.length){
                    throw new NoSuchElementException();
                }
            }
            if (i>=incoming_args.length) {
                result = false;
            } else {
                result = true;
            }
            result = true;
        }
        return result;
    }
//проверяет можно ли идти дальше , возвращает текущий эдемент(если он четный) и передвигает каретку
    @Override
    public Object next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        //--проверка четности
        while(incoming_args[index]%2!=0){
            index++;
            if(!hasNext()){
                throw new NoSuchElementException();
            }
        }
        int i = incoming_args[index];
        //--проверка четности
        index++;
        return  i;
    }
}
