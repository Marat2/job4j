package ru.job4j.simplearray;

public class SimpleArray<T> {

    public Object[] result;
    private int curIndex = 0;
    public SimpleArray(int length) {
        this.result = new Object[length];
    }

    public int size() {
        return curIndex;
    }

    public void add(T model) throws OutOfLimitException {
        if (curIndex == result.length) {
            throw new OutOfLimitException("Превышен порог массива");
        }
        result[curIndex++] = model;
    }

    public void set(int index, T model)  {
        if (index < 0 || index >= curIndex) {
            throw new IndexOutOfBoundsException();
        }
        result[index] = model;
    }

    public void remove(int index) {
        if (index < 0 || index >= curIndex) {
            throw new IndexOutOfBoundsException();
        }
        Object[] arrOut = new Object[result.length - 1];
        int sourcePos = index + 1;
        int destPos = index;
        int len = result.length - index - 1;
        System.arraycopy(result, sourcePos, result, destPos, len);
        curIndex--;
        //result = Arrays.copyOf(result, result.length - 1);
    }

    public T get(int index) {
        if (index < 0 || index >= curIndex) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.result[index];
    }

    public T[] getResult() {
        return (T[]) this.result;
    }
}
