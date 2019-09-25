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

    @Test
    public void whenExit() {
        StubInput input = new StubInput(new String[] {"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenAddItemAndShow() {
        StubInput input = new StubInput(new String[] {"0","new item","new desc"});
        ShowStubInput show = new ShowStubInput();
        new StartUI().init(input,new Tracker(),new UserAction[] { show });
        assertThat(show.isCall(),is(true));
    }
    @Test
    public void whenAddItemChangeAndShow() {
        Tracker tracker=new Tracker();
        Item item=new Item("new item","new desc");
        tracker.add(item);
        StubInput input = new StubInput(new String[] {"0",item.getId(),"change item","change desc"});
        ReplaceStubAction show = new ReplaceStubAction();
        new StartUI().init(input,tracker,new UserAction[] { show });
        assertThat(show.isCall(),is(true));
    }

    @Test
    public void whenAddTwoItemChangeSecondDeleteFirstAndShow() {
        Tracker tracker=new Tracker();
        Item first=new Item("first item","first desc");
        Item second=new Item("second item","second desc");
        tracker.add(first);
        tracker.add(second);
        StubInput input = new StubInput(new String[] {"0",second.getId(),"change item","change desc",first.getId()});
        DeleteStubInput delete = new DeleteStubInput();
        new StartUI().init(input,tracker,new UserAction[] { delete });
        assertThat(delete.isCall(),is(true));
    }

    @Test
    public void whenShowItems() {
        this.loadOutput();
        Tracker tracker=new Tracker();
        Item item=new Item("new item","new desc");
        tracker.add(item);
        StubInput input = new StubInput(new String[] {"0"});
        ShowStubAction show = new ShowStubAction();
        new StartUI().init(input,tracker,new UserAction[] { show });
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append("Menu.").append(System.lineSeparator())
                                .append("0. === Show all items ====").append(System.lineSeparator())
                                .append("№"+item.getId()+"   name :  new item")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        this.backOutput();
    }

    @Test
    public void whenFinItemByid() {
        this.loadOutput();
        Tracker tracker=new Tracker();
        Item item=new Item("new item","new desc");
        tracker.add(item);
        StubInput input = new StubInput(new String[] {"0",item.getId()});
        FindByIdStubAction find = new FindByIdStubAction();
        new StartUI().init(input,tracker,new UserAction[] { find });
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append("Menu.").append(System.lineSeparator())
                                .append("0. === Find item by Id ====").append(System.lineSeparator())
                                .append("№"+item.getId()+"     new item")
                                .append(System.lineSeparator())
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
