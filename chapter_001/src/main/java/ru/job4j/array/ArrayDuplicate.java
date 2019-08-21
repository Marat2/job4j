package ru.job4j.array;
import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] input){

        int counter=input.length;
        for (int x=0;x<counter;x++) {
            String temp=input[x];
            for (int y=x+1;y<counter;y++) {
                if (temp.equals(input[y])) {
                    input[y]=input[counter-1];
                    --counter;
                    --y;                }
            }
        }
        return Arrays.copyOf(input,counter);
    }
}
