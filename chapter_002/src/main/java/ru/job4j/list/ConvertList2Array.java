package ru.job4j.list;

import java.util.List;
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int rowNum = 0;
        int cellNum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (cellNum == 3) {
                cellNum = 0;
                rowNum++;
            }
            array[rowNum][cellNum] = list.get(i);
            cellNum++;
        }
        return array;
    }
}
