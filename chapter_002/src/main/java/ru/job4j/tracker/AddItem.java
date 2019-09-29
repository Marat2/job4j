package ru.job4j.tracker;

public class AddItem extends BaseAction/*implements UserAction*/ {
    public AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        String desc = input.askStr("Enter description:");
        tracker.add(new Item(name, desc));
    }

    /*public AddItem( String name,int key) {
        super(name, key);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        String desc = input.askStr("Enter description:");
        tracker.add(new Item(name, desc));
    }*/
}
