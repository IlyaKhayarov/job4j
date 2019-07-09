package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.start.Input;
import ru.job4j.start.StartUI;
import ru.job4j.start.StubInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUsedAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"}); //создаем StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        //создаем StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name2", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(),is("test name2"));
    }
}
