package ru.job4j.tracker;

public class DeleteAction  extends BaseAction /*implements UserAction*/ {

    public DeleteAction(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.print("Enter item id: ");
        String deleteid = input.askStr("");
        tracker.delete(deleteid);
    }

}
