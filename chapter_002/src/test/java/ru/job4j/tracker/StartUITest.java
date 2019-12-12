package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {
    //private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = (x) -> System.out.println(x.toLowerCase());
        private final PrintStream stdout = new PrintStream(out);
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

        new StartUI(input, tracker, output).init();
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append("0 : add item").append(System.lineSeparator())
                                .append("1 : show all items").append(System.lineSeparator())
                                .append("2 : edit item").append(System.lineSeparator())
                                .append("3 : delete item").append(System.lineSeparator())
                                .append("4 : find item by id").append(System.lineSeparator())
                                .append("5 : find items by name").append(System.lineSeparator())
                                .append("6 : exit program").append(System.lineSeparator())
                                .append("№" + item.getId() + "     new item")
                                .append(System.lineSeparator())
                                .append("0 : add item").append(System.lineSeparator())
                                .append("1 : show all items").append(System.lineSeparator())
                                .append("2 : edit item").append(System.lineSeparator())
                                .append("3 : delete item").append(System.lineSeparator())
                                .append("4 : find item by id").append(System.lineSeparator())
                                .append("5 : find items by name").append(System.lineSeparator())
                                .append("6 : exit program").append(System.lineSeparator())
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
