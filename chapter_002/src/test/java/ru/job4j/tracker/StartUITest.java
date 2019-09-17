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
    @Test
    public void whenUserShowItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("new item",  "new desc"));
        tracker.add(new Item("new item2",  "new desc2"));
        String CYCLE = "";
        for (Item item:tracker.findAll()) {
             CYCLE += "".concat(item.getName() + "  № " + item.getId()).concat(System.lineSeparator());
        }
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(ADD.concat("------------ Список заявок --------------")
                        .concat(System.lineSeparator())
                        .concat(CYCLE)
                        .concat("-----------------------------------------")
                        .concat(System.lineSeparator())
                        .concat(ADD)
                        .concat("------------- Выход -------------")
                        .concat(System.lineSeparator())
                ));
    }
    @Test
    public void whenUserEditItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("new item", "new desc"));
        tracker.add(new Item("new item2", "new desc2"));
        String START = "".concat("------------ Редактирование заявки --------------");
        Item item = new Item("new item222", "new desc3232");
        boolean result = tracker.replace(tracker.findAll()[0].getId(), item);
        String OUTPUT;
        if (result) {
             OUTPUT = "".concat("------------ Заявка с getId : " + tracker.findAll()[0].getId() + "-----------").concat(System.lineSeparator())
                  .concat("------------ Новое название : " + item.getName() + "-----------").concat(System.lineSeparator())
                  .concat("------------ Новое описание : " + item.getDesc() + "-----------").concat(System.lineSeparator())
                  .concat("-----------------------------------------").concat(System.lineSeparator());
        } else {
             OUTPUT = "".concat("------------ Ошибка замещения -----------").concat(System.lineSeparator())
                  .concat("-----------------------------------------").concat(System.lineSeparator());
        }
        Input input = new StubInput(new String[]{"2", tracker.findAll()[0].getId(), "new item222", "new desc3232", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(ADD.concat(START).concat(System.lineSeparator()).concat(OUTPUT).concat(ADD).concat("------------- Выход -------------").concat(System.lineSeparator())));
    }
    @Test
    public void whenUserDeleteItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("new item",  "new desc"));
        String START = "".concat("------------ Удаление заявки --------------");
        boolean result = true;
        String OUTPUT;
        if (result) {
            OUTPUT = "".concat("------------ Заявка удалена --------------").concat(System.lineSeparator())
                       .concat("-----------------------------------------").concat(System.lineSeparator());
        } else {
            OUTPUT = "".concat("------------ Ошибка удаления -----------").concat(System.lineSeparator())
                       .concat("-----------------------------------------").concat(System.lineSeparator());
        }
        Input input = new StubInput(new String[]{"3", tracker.findAll()[0].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(ADD.concat(START).concat(System.lineSeparator()).concat(OUTPUT).concat(ADD).concat("------------- Выход -------------").concat(System.lineSeparator())));
    }
    @Test
    public void whenUserfindItemById() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("new item",  "new desc"));
        Item item = tracker.findById(tracker.findAll()[0].getId());
        String START = "".concat("------------ Выбрать заявку --------------");
        String OUTPUT;
        if (item != null) {
            OUTPUT = "".concat("------------ Заявка с getId : " + item.getId() + "-----------").concat(System.lineSeparator())
                       .concat("------------ Новое название : " + item.getName() + "-----------").concat(System.lineSeparator())
                       .concat("------------ Новое описание : " + item.getDesc() + "-----------").concat(System.lineSeparator())
                       .concat("-----------------------------------------").concat(System.lineSeparator());
        } else {
            OUTPUT = "".concat("----------- Элемент не найден ---------").concat(System.lineSeparator());
        }
        Input input = new StubInput(new String[]{"4", tracker.findAll()[0].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(ADD.concat(START).concat(System.lineSeparator()).concat(OUTPUT).concat(ADD).concat("------------- Выход -------------").concat(System.lineSeparator())));
    }
    @Test
    public void whenUserfindItemByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("new item",  "new desc"));
        String START = "".concat("------------ Выбрать заявку по названию--------------");
        String CYCLE = "";
        for (Item item:tracker.findByName("new item")) {
            CYCLE += "".concat("№".concat(item.getId()).concat("   ").concat(item.getName())).concat(System.lineSeparator()).concat("Описание: " + item.getDesc()).concat(System.lineSeparator());
        }
        String END = "-----------------------------------------".concat(System.lineSeparator());
        Input input = new StubInput(new String[]{"5", "new item", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(ADD.concat(START).concat(System.lineSeparator()).concat(CYCLE).concat(END).concat(ADD).concat("------------- Выход -------------").concat(System.lineSeparator())));
    }
}
