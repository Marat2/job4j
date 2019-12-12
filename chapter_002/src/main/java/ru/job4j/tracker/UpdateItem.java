package ru.job4j.tracker;

import java.util.function.Consumer;

public class UpdateItem  extends BaseAction  {
    private final Consumer<String> output;
    public UpdateItem(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept(String.format("Enter item id: "));
        String id = input.askStr("");
        output.accept(String.format("Enter new name: "));
        String newname = input.askStr("");
        output.accept(String.format("Enter new description: "));
        String newdesc = input.askStr("");
        Item newitem = new Item(newname, newdesc);
        tracker.replace(id, newitem);
    }
}
