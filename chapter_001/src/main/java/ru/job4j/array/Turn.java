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
        int to_right;
        int to_left;
        if (array.length%2!=0) {
            for (int x = 0; x < array.length; x++) {
                to_right = x;
                to_left = array.length - x - 1;
                if (to_right == to_left) {
                    break;
                }
                temt = array[to_right];
                array[x] = array[to_left];
                array[to_left] = temt;
            }
        } else {
            for (int x = 0; x < array.length; x++) {
                to_right = x;
                to_left = array.length - x - 1;
                if (to_right == to_left+1) {
                    break;
                }
                temt = array[to_right];
                array[x] = array[to_left];
                array[to_left] = temt;
            }
        }
        return array;
    }
}
