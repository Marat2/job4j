package ru.job4j.tracker;

public class ReplaceAction  extends BaseAction  /*implements UserAction*/   {
    public ReplaceAction(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.print("Enter item id: ");
        String id = input.askStr("");
        System.out.print("Enter new name: ");
        String newname = input.askStr("");
        System.out.print("Enter new description: ");
        String newdesc = input.askStr("");
        Item newitem = new Item(newname, newdesc);
        tracker.replace(id, newitem);
    }
    /*@Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter item id: ");
        String id = input.askStr("");
        System.out.print("Enter new name: ");
        String newname = input.askStr("");
        System.out.print("Enter new description: ");
        String newdesc = input.askStr("");
        Item newitem = new Item(newname, newdesc);
        tracker.replace(id, newitem);
        return true;
    }*/
}
