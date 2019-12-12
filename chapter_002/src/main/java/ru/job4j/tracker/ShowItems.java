package ru.job4j.tracker;

import java.util.function.Consumer;

public class ShowItems extends BaseAction  {
    private final Consumer<String> output;
    public ShowItems(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int x = 0; x < tracker.findAll().length; x++) {
            output.accept(String.format("№".concat(items[x].getId().concat("     ").concat(items[x].getName()))));
        }
    }
}
