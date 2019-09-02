package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        int all = monthly * 12;
        double credit = (amount + ((amount / 100) * percent));
        while (credit > 0) {
            ++year;
            credit = credit - all;
        }
        return year;
    }
}
