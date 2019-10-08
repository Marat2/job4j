package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void firstVersionSingltonTest(){
        TrackerFirst tracker = TrackerFirst.INSTANCE;
        TrackerFirst tracker1 = TrackerFirst.INSTANCE;
        assertEquals(tracker.hashCode(), tracker1.hashCode());
    }
    @Test
    public void secondVersionSingltonTest(){
        TrackerSecond tracker = TrackerSecond.getInstance ();
        TrackerSecond tracker1 = TrackerSecond.getInstance ();
        assertEquals(tracker.hashCode(), tracker1.hashCode());
    }
    @Test
    public void thirdVersionSingltonTest(){
        TrackerThird tracker = TrackerThird.getInstance();
        TrackerThird tracker1 = TrackerThird.getInstance();
        assertEquals(tracker.hashCode(), tracker1.hashCode());
    }
    @Test
    public void fourthVersionSingltonTest(){
        TrackerFourth tracker = TrackerFourth.getInstance();
        TrackerFourth tracker1 = TrackerFourth.getInstance();
        assertEquals(tracker.hashCode(), tracker1.hashCode());
    }
    @Test
    public void testSingleton() {
        TrackerSecond instance1 = TrackerSecond.getInstance();
        TrackerSecond instance2 = TrackerSecond.getInstance();
        assertEquals(true, instance1==instance2);

    }
    /*@Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Tracker expected = new Tracker();
        Item item = new Item("test1");
        Item next = new Item("test2");
        next.setId(item.getId());
        tracker.add(item);
        tracker.add(next);
        expected.add(next);
        boolean expect = true;
        assertThat(tracker.delete(item.getId()), is(expect));
    }
    @Test
    public void whenDeleteItemThenNoItem() {
        Tracker tracker = new Tracker();
        Tracker expected = new Tracker();
        Item item = new Item("test1");
        Item next = new Item("test2");
        next.setId(item.getId());
        tracker.add(item);
        tracker.add(next);
        expected.add(next);
        tracker.delete(item.getId());
        Assert.assertNull(tracker.findById(item.getId()));
    }
    @Test
    public void findAllItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item next = new Item("test2");
        next.setId(item.getId());
        tracker.add(item);
        tracker.add(next);
        Assert.assertEquals(2, tracker.findAll().length);
    }
    @Test
    public void findByNameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item next = new Item("test2");
        Item third = new Item("test1");
        next.setId(item.getId());
        tracker.add(item);
        tracker.add(next);
        tracker.add(third);
        Assert.assertEquals(2, tracker.findByName("test1").length);
    }*/
}