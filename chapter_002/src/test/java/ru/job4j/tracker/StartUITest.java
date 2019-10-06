package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /*@Test
    public void whenExit() {
        StubInput input = new StubInput(new String[] {"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker());
        assertThat(action.isCall(), is(true));
    }*/

    @Test
    public void whenShowItems() {
        this.loadOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item", "new desc");
        tracker.add(item);
        StubInput input = new StubInput(new String[] {"1", "6"});

        new StartUI().init(input, tracker);
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append("0 : Add Item").append(System.lineSeparator())
                                .append("1 : Show all items").append(System.lineSeparator())
                                .append("2 : Edit item").append(System.lineSeparator())
                                .append("3 : Delete item").append(System.lineSeparator())
                                .append("4 : Find item by Id").append(System.lineSeparator())
                                .append("5 : Find items by name").append(System.lineSeparator())
                                .append("6 : Exit Program").append(System.lineSeparator())
                                .append("№" + item.getId() + "     new item")
                                .append(System.lineSeparator())
                                .append("0 : Add Item").append(System.lineSeparator())
                                .append("1 : Show all items").append(System.lineSeparator())
                                .append("2 : Edit item").append(System.lineSeparator())
                                .append("3 : Delete item").append(System.lineSeparator())
                                .append("4 : Find item by Id").append(System.lineSeparator())
                                .append("5 : Find items by name").append(System.lineSeparator())
                                .append("6 : Exit Program").append(System.lineSeparator())
                                .toString()
                )
        );
        this.backOutput();
    }

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
}
