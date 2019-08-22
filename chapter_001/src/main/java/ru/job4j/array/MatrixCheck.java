package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int x=0;x<data.length;x++) {
                if(data[x][x]!=data[0][0]){
                    result = false;
                    break;
                }
                if(data[x][data.length-x-1]!=data[0][0]){
                    result=false;
                    break;
                }
        }
        return result;
    }
}
