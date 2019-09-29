package ru.job4j.tracker;

public class CreateAction extends BaseAction/*implements UserAction*/  {

    public CreateAction(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.print("Enter name: ");
        String name = input.askStr("");
        System.out.print("Enter desc: ");
        String desc = input.askStr("");
        Item item = new Item(name, desc);
        tracker.add(item);
    }
    /*@Override
    public String name() {
        return "=== Create a new Item ====";
    }*/

    /*@Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter name: ");
        String name = input.askStr("");
        System.out.print("Enter desc: ");
        String desc = input.askStr("");
        Item item = new Item(name, desc);
        tracker.add(item);
        return true;
    }*/
}
