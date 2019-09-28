package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new  Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        if (!isNumeric(scanner.nextLine())){
            throw new NumberFormatException(String.format("Please enter validate data again "));
        }
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);

        if (select < 0 || select >= max) {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }

        return select;
    }
    public boolean isNumeric(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
