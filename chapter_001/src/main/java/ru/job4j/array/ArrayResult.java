package ru.job4j.array;

public class ArrayResult {
    public int[] create(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        for (int x = 0, i = 0; x < first.length; x++, i++) {
            if (first[x] > second[x]) {
                result[x + i] = second[x];
                result[x + 1 + i] = first[x];
            } else {
                result[x + i] = first[x];
                result[x + 1 + i] = second[x];
            }
        }
        return result;
    }
}
