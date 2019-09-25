package ru.job4j.tracker;

public class CreateAction implements UserAction  {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter name: ");
        String name = input.askStr("");
        System.out.print("Enter desc: ");
        String desc = input.askStr("");
        Item item = new Item(name, desc);
        tracker.add(item);
        return true;
    }
}
