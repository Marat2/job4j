package ru.job4j.tracker;

public class FindByNameAction implements UserAction  {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter item name: ");
        String showname = input.askStr("");
        tracker.findByName(showname);
        return true;
    }
}
