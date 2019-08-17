package ru.job4j.calculate;

/**
 * Class Класс для вычисления арифметических операций + - * / ^.
 * @author msaubanov
 * since 17.08.2019
 * @version 1
 */
public class Calculate {
    public static void main(String[] arg) {
        System.out.println("Calculate...");
        double first = Double.valueOf(arg[0]);
        double second = Double.valueOf(arg[1]);
        System.out.println(String.format("%s + %s = %s",first,second,add(first,second)));
        System.out.println(String.format("%s - %s = %s",first,second,substract(first,second)));
        System.out.println(String.format("%s * %s = %s",first,second,multiple(first,second)));
        System.out.println(String.format("%s / %s = %s",first,second,div(first,second)));
        System.out.println(String.format("%s ^ %s = %s",first,second,expand(first,(int)second)));
    }

    /**
     * Сложение
     * @param first первый аргумент.
     * @param second второй аргумент.
     * @return результат
     */
    private static double add(double first,double second){
        return first+second;
    }

    /**
     * Вычитание
     * @param first первый аргумент.
     * @param second второй аргумент.
     * @return результат
     */
    private static double substract(double first,double second){
        return first-second;
    }

    /**
     * Умножение
     * @param first первый аргумент.
     * @param second второй аргумент.
     * @return результат
     */
    private static double multiple(double first,double second){
        return first*second;
    }

    /**
     * Деление
     * @param first первый аргумент.
     * @param second второй аргумент.
     * @return результат
     */
    private static double div(double first,double second){
        return  first/second;
    }

    /**
     * Возведение в степень
     * @param first первый аргумент.
     * @param second второй аргумент.
     * @return результат
     */
    private static double expand(double first,double second){
        return Math.pow(first,second);
    }
}
