package ru.job4j.tracker;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
public class StartUITest {
    //тесты, использующие класс StubInput для эмуляции поведения пользовател
    //Тест-методы должны вместо пользователя выбирать пункты меню, вводить необходимые данные и выходить из приложения, после этого проверить изменение данных в Tracker;
    //Необходимо написать тесты на все пункты меню, кроме вывода информации на консоль.
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
}
