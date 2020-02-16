package job4j.simplearray;

import java.util.Arrays;


public class SimpleArray<T> {

    public Object[] result;
    private int index = 0;

    public SimpleArray(int length) {
        this.result = new Object[length];
    }
    public void add(T model) throws OutOfLimitException {//выкинуть ошибку
        if (index == result.length){
            throw new OutOfLimitException("Превышен порог массива");
        }
        result[index++]=model;
    }
    public void set(int index, T model){
        result[index]=model;
    }
    public void remove(int index){
        int sourcePos = index+1;
        int destPos = index;
        int len = result.length-index-1;
        System.arraycopy(result,sourcePos,result,destPos,len);
        result = Arrays.copyOf(result, result.length-1);
    }
    public T get(int index){
        return (T)this.result[index];
    }
    public T[] getResult(){
        return (T[]) this.result;
    }
}
