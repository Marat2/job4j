package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter item id: ");
        String deleteid = input.askStr("");
        tracker.delete(deleteid);
        return true;
    }
}
