package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
public class StartUITest {

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private static final String ADD = ""
            .concat("Меню.")
            .concat(System.lineSeparator())
            .concat("Для добавления элемента нажмите 0")
            .concat(System.lineSeparator())
            .concat("Для вывода всех элементов нажмите 1")
            .concat(System.lineSeparator())
            .concat("Для редактирования элемента нажмите 2")
            .concat(System.lineSeparator())
            .concat("Для удаления заявки нажмите 3")
            .concat(System.lineSeparator())
            .concat("Для нахождения заявки по ее id нажмите 4")
            .concat(System.lineSeparator())
            .concat("Для нахождения заявки по ее имени нажмите 5")
            .concat(System.lineSeparator())
            .concat("Для выхода нажмите 6")
            .concat(System.lineSeparator());

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {

        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name",  "desc"));

        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});

        new StartUI(input, tracker).init();

        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenUserAddItemAndDelete() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name",  "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }
    @Test
    public void whenUserAddItemAndFindIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("new item", "new desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("new item"));
    }
    @Test
    public void whenUserAddItemAndFindItByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("new item", "new desc"));
        Input input = new StubInput(new String[]{"5", "new item", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("new item"));
    }
    @Test
    public void whenUserAddItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("new item", "new desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(ADD.concat("------------ Список заявок --------------")
                   .concat(System.lineSeparator())
                   .concat(item.getName() + "  № " + item.getId())
                   .concat(System.lineSeparator())
                   .concat("-----------------------------------------")
                   .concat(System.lineSeparator())
                   .concat(ADD)
                   .concat("------------- Выход -------------")
                   .concat(System.lineSeparator())
                ));
    }
}
