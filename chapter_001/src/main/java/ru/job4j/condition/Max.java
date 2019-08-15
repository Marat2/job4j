package ru.job4j.condition;

public class Max {
    public int max(int left, int right) {
        int result=left;
        result = (left<right) ? right : result;
        return result;
    }
}
