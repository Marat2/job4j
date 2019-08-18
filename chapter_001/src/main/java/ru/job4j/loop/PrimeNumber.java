package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int x=2;x<=finish;x++){
            int sqrt_round= (int)Math.floor(Math.sqrt(x));
            if (sqrt_round==1){
                ++count;
            }else{
                boolean flag=true;
                for (int y=2;y<=x;y++){
                    if (x%y!=0) {
                        flag=false;
                    }else if(x%y==0 && y<x) {
                        flag=true;
                        break;
                    }
                }
                if (flag==false){
                    ++count;
                }
            }
        }
        return count;
    }
}
