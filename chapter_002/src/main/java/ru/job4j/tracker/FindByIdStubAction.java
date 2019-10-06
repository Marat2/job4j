package ru.job4j.tracker;

public class FindByIdStubAction implements UserAction {
    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return null;
    }

    /*private boolean call = false;

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        //System.out.print("Enter item id: ");
        String showid = input.askStr("");
        tracker.findById(showid);
        System.out.println("№".concat(tracker.findById(showid).getId().concat("     ").concat(tracker.findById(showid).getName())));
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }*/
}
