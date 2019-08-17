package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        int per_year=monthly*12;
        double credit_with_per=(amount+((amount/100)*percent));
        while(credit_with_per>0){
            ++year;
            credit_with_per=credit_with_per-per_year;
        }
        return year;
    }
}
