package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true; 
        for (int x=0;x<data.length;x++) {
                if(data[x][x]!=data[0][0]){
                    result = false;
                    break;
                }
                if(data[0][data.length-1]!=data[x][data.length-x-1]){
                    result=false;
                    break;
                }
        }
        return result;
    }
}
