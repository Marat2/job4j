package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException n) {
                System.out.println();
            }
        } while (invalid);
        return value;
    }
    @Override
    public int askInt(String question,int max){
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question,max);
                invalid = false;
            }catch (IllegalStateException s) {
                System.out.println("Please select key from menu ");
            }catch (NumberFormatException e) {
                System.out.println("Please enter validate data again ");
            }
        }while (invalid);
        return value;
    }
}
