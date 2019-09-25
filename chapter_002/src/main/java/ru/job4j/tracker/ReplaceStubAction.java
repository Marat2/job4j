package ru.job4j.tracker;

public class ReplaceStubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("");
        String newname = input.askStr("");
        String newdesc = input.askStr("");
        Item newitem = new Item(newname, newdesc);
        tracker.replace(id, newitem);
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
