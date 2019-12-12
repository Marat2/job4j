package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    private boolean run = true;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    public void init(/*Input input, Tracker tracker*/) {

        Input validate = new ValidateInput(input);
        MenuTracker menuTracker = new MenuTracker(validate, tracker, output);
        menuTracker.fillActions(this);

        while (this.run) {
            menuTracker.show();
            int select = input.askInt("Select: ", menuTracker.getActionsLentgh());
            menuTracker.select(select);
        }
    }

    public void stop() {
        this.run = false;
    }
}
