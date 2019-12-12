package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {
    private final Consumer<String> output;
    public DeleteItem(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept(String.format("Enter item id: "));
        String deleteid = input.askStr("");
        tracker.delete(deleteid);
    }
}
