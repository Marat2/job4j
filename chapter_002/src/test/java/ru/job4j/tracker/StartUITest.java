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
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

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
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name",  "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenUserAddItemAndDelete() {
        Tracker tracker = new Tracker();     // создаём Tracker
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
        Tracker tracker = new Tracker();     // создаём Tracker
        Item item = tracker.add(new Item("new item", "new desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                //"Меню.\r\nДля добавления элемента нажмите 0\r\nДля вывода всех элементов нажмите 1\r\nДля редактирования элемента нажмите 2\r\nДля удаления заявки нажмите 3\r\nДля нахождения заявки по ее id нажмите 4\r\nДля нахождения заявки по ее имени нажмите 5\r\nДля выхода нажмите 6\r\n
                                //Меню.\r\nДля добавления элемента нажмите 0\r\nДля вывода всех элементов нажмите 1\r\nДля редактирования элемента нажмите 2\r\nДля удаления заявки нажмите 3\r\nДля нахождения заявки по ее id нажмите 4\r\nДля нахождения заявки по ее имени нажмите 5\r\nДля выхода нажмите 6\r\n------------- Выход -------------\r\n"
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("Для добавления элемента нажмите 0")
                                .append(System.lineSeparator())
                                .append("Для вывода всех элементов нажмите 1")
                                .append(System.lineSeparator())
                                .append("Для редактирования элемента нажмите 2")
                                .append(System.lineSeparator())
                                .append("Для удаления заявки нажмите 3")
                                .append(System.lineSeparator())
                                .append("Для нахождения заявки по ее id нажмите 4")
                                .append(System.lineSeparator())
                                .append("Для нахождения заявки по ее имени нажмите 5")
                                .append(System.lineSeparator())
                                .append("Для выхода нажмите 6")
                                .append(System.lineSeparator())
                                .append("------------ Список заявок --------------")
                                .append(System.lineSeparator())
                                .append(item.getName() + "  № " + item.getId())
                                .append(System.lineSeparator())
                                .append("-----------------------------------------")
                                .append(System.lineSeparator())
                                .append("Меню.")
                                .append(System.lineSeparator())
                                .append("Для добавления элемента нажмите 0")
                                .append(System.lineSeparator())
                                .append("Для вывода всех элементов нажмите 1")
                                .append(System.lineSeparator())
                                .append("Для редактирования элемента нажмите 2")
                                .append(System.lineSeparator())
                                .append("Для удаления заявки нажмите 3")
                                .append(System.lineSeparator())
                                .append("Для нахождения заявки по ее id нажмите 4")
                                .append(System.lineSeparator())
                                .append("Для нахождения заявки по ее имени нажмите 5")
                                .append(System.lineSeparator())
                                .append("Для выхода нажмите 6")
                                .append(System.lineSeparator())
                                .append("------------- Выход -------------")
                                .append(System.lineSeparator())
                                .toString()
                )); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
}
