package ru.job4j.array;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int x=1;x<=size;x++) {
            for (int y=1;y<=size;y++){
                table[x-1][y-1]=x*y;
            }
        }
        return table;
    }
}
