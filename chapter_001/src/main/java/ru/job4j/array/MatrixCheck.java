package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int counter=0;
        boolean first=data[0][0];
        for (int x=0;x<data.length;x++) {
            counter++;
                int inner=data[x].length-counter;
                if(data[x][counter-1]==data[x][inner]==first){
                    break;
                }else{
                    result=false;
                    break;
                }
        }
        return result;
    }
}
