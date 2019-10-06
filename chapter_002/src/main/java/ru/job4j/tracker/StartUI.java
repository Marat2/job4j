package ru.job4j.tracker;

public class StartUI {
    private boolean run = true;
    public void init(Input input, Tracker tracker) {

        //Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        //Tracker tracker = new Tracker();
        MenuTracker menuTracker = new MenuTracker(validate,tracker);
        menuTracker.fillActions(this);

        while (this.run) {
            menuTracker.show();
            int select = input.askInt("Select: ",menuTracker.getActionsLentgh());
            menuTracker.select(select);
        }
    }

    public void stop(){
        this.run=false;
    }
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].info());
        }
    }

}
