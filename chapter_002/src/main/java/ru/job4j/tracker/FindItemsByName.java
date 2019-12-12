package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindItemsByName extends BaseAction   {
    private final Consumer<String> output;
    public FindItemsByName(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept(String.format("Enter item name: "));
        String showname = input.askStr("");
        tracker.findByName(showname);
    }
}
