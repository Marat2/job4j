package ru.job4j.tracker;

public class ShowStubInput implements UserAction  {
    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return null;
    }
    /*private boolean call = false;

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("");
        String desc = input.askStr("");
        Item item = new Item(name, desc);
        tracker.add(item);
        Item[] items = tracker.findAll();
        for (int x = 0; x < tracker.findAll().length; x++) {
            System.out.println("№".concat(items[x].getId().concat("     ").concat(items[x].getName())));
        }
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }*/
}
