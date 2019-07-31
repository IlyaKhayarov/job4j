package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.start.StartUI;
import ru.job4j.start.StubInput;
import ru.job4j.start.ValidateInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private String st2 =
                    "0. Add new Item.\r\n" +
                    "1. All Items.\r\n" +
                    "2. Edit item.\r\n" +
                    "3. Delete item.\r\n" +
                    "4. Find item by id.\r\n" +
                    "5. Find item by name.\r\n" +
                    "6. Exit Program.\r\n";


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
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"0", "test name", "desc", "y"})
        ); //создаем StubInput с последовательностью действий
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("------------- Добавление новой заявки ---------------\r\n")
                                .append("------------ Новая заявка с Id : ")
                                .append(tracker.findAll()[0].getId())
                                .append(" -----------\r\n")
                                .append("------------ Новая заявка с Name : ")
                                .append(tracker.findAll()[0].getName())
                                .append(" -----------\r\n")
                                .append("------------ Новая заявка с Desc : ")
                                .append(tracker.findAll()[0].getDecs())
                                .append(" -----------\r\n")
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
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"2", item.getId(), "test name", "заменили заявку", "y"})
        );
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("------------------ Заявка найдена -------------------\r\n")
                                .append("----------- Замена заявки прошла успешно ------------\r\n")
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
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"3", item.getId(), "y"})
        );
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("----------------- Заявка найдена --------------------\r\n")
                                .append("---------- Удаление заявки прошло успешно -----------\r\n")
                                .toString()
                        )
                )
        );
    }

    @Test
    public void whenUsedAllItemThenTrackerHasAllItems() {
        Tracker tracker = new Tracker();
        Item item2 = tracker.add(new Item("test name", "desc2", System.currentTimeMillis()));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"1", "y"})
        );
        new StartUI(input, tracker).init();
        //assertThat(tracker.findAll()[0].getName(), is("test name2"));
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("----------------- Вывод всех заявок -----------------\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .append("Номер заявки   Имя   Описание       id   \r\n")
                                .append("1              " + tracker.findAll()[0].getName() +
                                        "" + tracker.findAll()[0].getDecs() +
                                        "          " + tracker.findAll()[0].getId() + "\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .toString()
                        )
                )
        );
    }

    @Test
    public void whenFindByIdItemThenTrackerHasValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"4", item.getId(), "y"})
        );
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("----------------- Заявка найдена --------------------\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .append("Номер заявки   Имя   Описание       id   \r\n")
                                .append("" + tracker.findAll()[0].getId() + "  " + tracker.findAll()[0].getName() + "" + tracker.findAll()[0].getDecs() + "           " + tracker.findAll()[0].getId() + "\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .toString()
                        )
                )
        );
    }

    @Test
    public void whenFindByNameItemThenTrackerHasValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name2", "desc", System.currentTimeMillis()));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"5", item.getName(), "y"})
        );
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()),
                is(
                        (new StringBuilder()
                                .append(st2)
                                .append("-----------------------------------------------------\r\n")
                                .append("Номер заявки   Имя   Описание       id   \r\n")
                                .append("1              " + tracker.findAll()[0].getName() + "" + tracker.findAll()[0].getDecs() + "           " + tracker.findAll()[0].getId() + "\r\n")
                                .append("-----------------------------------------------------\r\n")
                                .append("------------------ Поиск закончен -------------------\r\n")
                                .toString()
                        )
                )
        );
    }
}
