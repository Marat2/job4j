package ru.job4j.tracker;

public class FindItemsByName extends BaseAction   {

    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.print("Enter item name: ");
        String showname = input.askStr("");
        tracker.findByName(showname);
    }
}
