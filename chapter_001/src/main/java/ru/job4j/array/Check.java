package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
            for (int x=1;x<data.length-1;x++) {
                if (data[0] != data[x]){
                    result =false;
                    break;
                }
            }
        return result;
    }
}
