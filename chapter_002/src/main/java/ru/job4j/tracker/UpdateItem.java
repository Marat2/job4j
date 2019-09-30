package ru.job4j.tracker;

public class UpdateItem  extends BaseAction  {
    public UpdateItem(int key, String name) {
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
}
