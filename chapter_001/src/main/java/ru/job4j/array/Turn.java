package ru.job4j.array;

/**
 * Class Класс для реверса массива.
 * @author msaubanov
 * since 17.08.2019
 * @version 1
 */

public class Turn {
    /**
     * реверс
     * @param array массив для реверса.
     * @return array перевернуый массив
     */
    public int[] back(int[] array) {
        int temt;
        int right;
        int left;
            for (int x = 0; x < array.length / 2; x++) {
                right = x;
                left = array.length - x - 1;
                temt = array[right];
                array[x] = array[left];
                array[left] = temt;
            }
        return array;
    }
}
