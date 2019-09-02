package ru.job4j.condition;

public class Max {
    public int max(int left, int right) {
        int result = left;
        result = (left < right) ? right : result;
        return result;
    }
    public int max(int left, int right, int third) {
        int result = left;
        result=(left<max(right,third)) ? max(right,third) : result;
        return result;
    }

    public int max(int left, int right, int third, int four) {
        int result = left;
        result=(left<max(max(right,third),four)) ? max(max(right,third),four) : result;
        return result;
    }
}
