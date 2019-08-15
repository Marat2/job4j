package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {
        int sum = 0;
        int x;
        for (x=start;x<=finish;x++){
            if(x%2==0){
                sum+=x;
            }
        }
        return sum;
    }
}
