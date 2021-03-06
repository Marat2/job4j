package ru.job4j.tracker;

public class FindByIdAction extends BaseAction /*implements UserAction*/ {
    public FindByIdAction(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.print("Enter item id: ");
        String showid = input.askStr("");
        tracker.findById(showid);
    }

}
