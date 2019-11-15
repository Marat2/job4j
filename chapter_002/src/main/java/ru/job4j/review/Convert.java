package ru.job4j.review;


import java.util.*;

public class Convert {
        //зачем тут нужен конструктор в таком виде лучше убрать
    public Convert(){

    }

    //Converts array to list
    List<Integer> makeList(int[][] array) {//явно не определен модификатор доступа
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                list.add(array[i][j]);
        }
        return list;
    }


    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);//можно результат деления округлять в больщую сторону через MAth.ceil
                                                                       //не используя такую конструкцию.
        //с одной стороны можно было конечно не создавать итератор
        // и просто пройтись по списку используя верхний предел list.size()
        //но тогда бы пришлось создать переменные для отчета текущий ячейки
        //я не знаю что лучше с точки зрения быстродействия.
        /*int cells = (int) Math.ceil((double) list.size() / rows);
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
        return array;*/
        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())
                    array[i][j] = iterator.next();
                else
                    array[i][j] = 0;//нет смысла заполнять остатки нулями т.к. массив типа int на все незаполненные ячейки последний строки
                                    //автоматом перевоит в 0
            }
        }
        return array;
    }
}