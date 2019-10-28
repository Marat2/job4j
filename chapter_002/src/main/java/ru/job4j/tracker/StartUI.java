package ru.job4j.tracker;

public class StartUI {
    private boolean run = true;
    public void init(Input input, Tracker tracker) {

        Input validate = new ValidateInput(input);
        MenuTracker menuTracker = new MenuTracker(validate, tracker);
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
