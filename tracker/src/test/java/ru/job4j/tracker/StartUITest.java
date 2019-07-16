package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.start.Input;
import ru.job4j.start.StartUI;
import ru.job4j.start.StubInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    Tracker tracker;
    Item item;

    @Before
    public void beforeMethod() {
        System.out.println("execute before method");
        Tracker tracker = new Tracker();
        this.tracker = tracker;
        Item item = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        this.item = item;
    }

    @After
    public void afterMethod() {
        System.out.println("execute after method");
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUsedAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"}); //создаем StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[1].getName(), is("test name"));
        Input input2 = new StubInput(new String[]{"2", item.getId(), "test name", "заменили заявку", "6"});
        new StartUI(input2, tracker).init();
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //создаем StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Item item2 = tracker.add(new Item("test name", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        //assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUsedAllItemThenTrackerHasAllItems() {
        Item item2 = tracker.add(new Item("test name", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
        assertThat(tracker.findAll()[1].getName(), is("test name"));
        Input input2 = new StubInput(new String[]{"2", item.getId(), "test name", "заменили заявку", "6"});
        new StartUI(input2, tracker).init();
    }

    @Test
    public void whenFindByIdItemThenTrackerHasValue() {
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
        Input input2 = new StubInput(new String[]{"2", item.getId(), "test name", "заменили заявку", "6"});
        new StartUI(input2, tracker).init();
    }

    @Test
    public void whenFindByNameItemThenTrackerHasValue() {
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
        Input input2 = new StubInput(new String[]{"2", item.getId(), "test name", "заменили заявку", "6"});
        new StartUI(input2, tracker).init();
    }

}
