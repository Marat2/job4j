package ru.job4j.tracker;

public class FindByNameAction extends BaseAction /*implements UserAction*/  {
    public FindByNameAction(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.print("Enter item name: ");
        String showname = input.askStr("");
        tracker.findByName(showname);
    }
}
