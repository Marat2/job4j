package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter item id: ");
        String showid = input.askStr("");
        tracker.findById(showid);
        return true;
    }
}
