package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindItemById extends BaseAction  {
    private final Consumer<String> output;
    public FindItemById(int key, String name, Consumer<String> output) {
        super(key, name);
        this.output = output;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept(String.format("Enter item id: "));
        String showid = input.askStr("");
        tracker.findById(showid);
    }
}
