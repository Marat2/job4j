package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = 1;
        if (n > 1) {
            for (int x = 1; x <= n; ++x) {
                result = x * result;
            }
        }
        return result;
    }
}
