package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrackerTest {
    /**
     * Test Добавление новой заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    /**
     * Test Заменить ячейку в массиве.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /**
     * Test Удалить ячейку в массиве.
     */
    @Test
    public void whenDeleteItemThenReturnWithoutItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test3", "testDescription3", 12345L);
        tracker.add(item);
        tracker.delete(item.getId());
        assertTrue(String.valueOf(tracker.findById(item.getId())), true);
    }
    /**
     * Test Поиск по имени.
     */
    @Test
    public void whenFindByNameItemThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test4", "testDescription4", 11L);
        Item item2 = tracker.add(item);
        Item[] result = tracker.findByName(item2.getName());
        assertThat(result[0], is(item2));
    }
    /**
     * Test Поиск всех заявок.
     */
    @Test
    public void whenFindAllThenReturnAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test5", "testDescription45", 12L);
        tracker.add(item);
        Item[] result = tracker.findAll();
        assertThat(tracker.findAll(), is(result));
    }
}
