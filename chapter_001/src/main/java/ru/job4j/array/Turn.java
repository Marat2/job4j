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
        int Right;
        int Left;
            for (int x = 0; x < array.length / 2; x++) {
                Right = x;
                Left = array.length - x - 1;
                temt = array[Right];
                array[x] = array[Left];
                array[Left] = temt;
            }
        return array;
    }
}
