package job4j.eveniterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    public final int[] incoming_args;
    private int index=0;

    public EvenIterator(int[] incoming_args) {
        this.incoming_args = incoming_args;
    }
    //как для одного элемента сделать что бы не было в для 4 что бы было?
    @Override
    public boolean hasNext() {
        //если нет четных элементов то он должен вернуть false(не трогать)
        return (incoming_args.length>index && incoming_args.length>1);
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
