package ru.job4j.array;

/**
 * Class Класс для выбора элемента по индексу.
 * @author msaubanov
 * since 17.08.2019
 * @version 1
 */
public class FindLoop {

    /**
     * Сложение
     * @param data массив для пойска до значению элемента.
     * @param el значение элемента.
     * @return индекс элемента
     */

    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index=0;index<data.length;index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
