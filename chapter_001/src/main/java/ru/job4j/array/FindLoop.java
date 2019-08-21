package ru.job4j.array;

/**
 * Class Класс для выбора элемента по индексу.
 * @author msaubanov
 * since 17.08.2019
 * @version 1
 */
public class FindLoop {

    /**
     * Поиск
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
    /**
     * Поиск в указанном диапазоне
     * @param data массив для пойска до значению элемента.
     * @param el значение элемента.
     * @param start нижняя груницца поиска
     * @param finish верхняя граница поиска
     * @return индекс элемента
     */
    //Для поиска минимального значения нужно использовать метод indexOf(int[] data, el, start, finish). Этот метод был реализован в предыдущей задачи.
    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int x=start;x<=finish;x++) {
            if (data[x]==el) {
                rst = x;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        for (int y=0;y<data.length;y++) {
            int temp = data[y];
            for (int x = y; x < data.length; x++) {
                if (temp <= data[x]) {
                    continue;
                } else {
                    int index = this.indexOf(data, data[x], x, x);
                    int cur_temp = this.indexOf(data, temp, 0, x);
                    data[cur_temp] = data[x];
                    data[index] = temp;
                    temp = data[cur_temp];
                }
            }
        }
        return data;
    }
}
