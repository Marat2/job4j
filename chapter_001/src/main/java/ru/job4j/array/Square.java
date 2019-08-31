package ru.job4j.array;

/**
 * Class Класс для заполнения массива квадратами значений.
 * @author msaubanov
 * since 17.08.2019
 * @version 1
 */
public class Square {
    /**
     * Сложение
     * @param bound верхняя граница.
     * @return массив квадратов чисел
     */

    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int x = 0; x < bound; x++) {
            rst[x] = (int) Math.pow(x + 1, 2);
        }
        return rst;
    }
}
