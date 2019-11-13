package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ConvertList2Array {
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] i:list) {
            List<Integer> list2 = new ArrayList<Integer>();
            for (Integer text:i) {
                list2.add(text);
            }
            result.addAll(list2);
        }
        return result;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int rowNum = 0;
        int cellNum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (cellNum == cells) {
                cellNum = 0;
                rowNum++;
            }
            array[rowNum][cellNum] = list.get(i);
            cellNum++;
        }
        return array;
    }
}
