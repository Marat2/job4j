package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first;
        result = (second > first) ? second : first;
        result = (result > third) ? result : third;
        return result;
    }
}
