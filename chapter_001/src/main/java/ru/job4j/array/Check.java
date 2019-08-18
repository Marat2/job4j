package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
            for (int x=0;x<data.length-1;x++) {
                if (data[x]==data[x+1] && x!=data.length-1) {
                    //result=true;
                    continue;
                }else if (data[x]==data[x+1] && x==data.length-1) {
                    result=true;
                    break;
                }else {
                    result=false;
                }
            }
        return result;
    }
}
