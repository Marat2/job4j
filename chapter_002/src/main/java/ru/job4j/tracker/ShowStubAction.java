package ru.job4j.tracker;

public class ShowStubAction implements UserAction  {
    private boolean call = false;

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int x = 0; x < tracker.findAll().length; x++) {
            System.out.println("№".concat(items[x].getId().concat("   name :  ").concat(items[x].getName())));
        }
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
