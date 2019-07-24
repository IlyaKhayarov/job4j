package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.start.Input;
import ru.job4j.start.StartUI;
import ru.job4j.start.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private String st2 =
            "Меню. \r\n" +
                    "0. Add new Item\r\n" +
                    "1. Show all items\r\n" +
                    "2. Edit item\r\n" +
                    "3. Delete item\r\n" +
                    "4. Find item by Id\r\n" +
                    "5. Find items by name\r\n" +
                    "6. Exit Program\r\n";


    @Before
    public void beforeMethod() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void afterMethod() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUsedAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"}); //создаем StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        StringBuilder st = new StringBuilder();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("------------ Добавление новой заявки --------------\r\n")
                                .append("------------ Новая заявка с getId : ")
                                .append(tracker.findAll()[0].getId())
                                .append(" -----------\r\n")
                                .append(st2)
                                .toString()
                        )
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        //создаем StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("------------------- Заявка найдена ---------------------\r\n")
                                .append("------------ Замена заявки прошла успешно --------------\r\n")
                                .append(st2)
                                .toString()
                        )
                )
        );
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Item item2 = tracker.add(new Item("test name", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("------------------- Заявка найдена -----------------------\r\n")
                                .append("------------ Удаление заявки прошло успешно --------------\r\n")
                                .append(st2)
                                .toString()
                        )
                )
        );
    }

    @Test
    public void whenUsedAllItemThenTrackerHasAllItems() {
        Tracker tracker = new Tracker();
        Item item2 = tracker.add(new Item("test name", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        //assertThat(tracker.findAll()[0].getName(), is("test name2"));
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("------------ Вывод всех заявок --------------\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .append("Номер заявки   Имя   Описание       id   \r\n")
                                .append("1              " + tracker.findAll()[0].getName() + "" + tracker.findAll()[0].getDecs() + "          " + tracker.findAll()[0].getId() + "\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .append(st2)
                                .toString()
                        )
                )
        );
    }

    @Test
    public void whenFindByIdItemThenTrackerHasValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("------------ Заявка найдена --------------\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .append("Номер заявки   Имя   Описание       id   \r\n")
                                .append("" + tracker.findAll()[0].getId() + "  " + tracker.findAll()[0].getName() + "" + tracker.findAll()[0].getDecs() + "           " + tracker.findAll()[0].getId() + "\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .append(st2)
                                .toString()
                        )
                )
        );
    }

    @Test
    public void whenFindByNameItemThenTrackerHasValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("------------ Поиск закончен --------------\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .append("Номер заявки   Имя   Описание       id   \r\n")
                                .append("1              " + tracker.findAll()[0].getName() + "" + tracker.findAll()[0].getDecs() + "           " + tracker.findAll()[0].getId() + "\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .append(st2)
                                .toString()
                        )
                )
        );
    }
}
