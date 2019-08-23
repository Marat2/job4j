package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        int perYear = monthly * 12;
        double creditWithper = (amount + ((amount / 100) * percent));
        while (creditWithper > 0) {
            ++year;
            creditWithper = creditWithper - perYear;
        }
        return year;
    }
}
