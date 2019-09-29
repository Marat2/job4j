package ru.job4j.tracker;

public class ShowAction extends BaseAction  /*implements UserAction*/ {

    public ShowAction(int key, String name) {
        super(key,name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int x = 0; x < tracker.findAll().length; x++) {
            System.out.println("№".concat(items[x].getId().concat("     ").concat(items[x].getName())));
        }
    }
    /*@Override
    public String name() {
        return "=== Show all items ====";
    }*/

    /*@Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int x = 0; x < tracker.findAll().length; x++) {
            System.out.println("№".concat(items[x].getId().concat("     ").concat(items[x].getName())));
        }
        return true;
    }*/
}
