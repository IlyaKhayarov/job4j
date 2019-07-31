package ru.job4j.start;

import ru.job4j.tracker.*;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект
     */
    private Input input;
    /**
     * @param хранит ссылку на объект
     */
    private Tracker tracker;

    /**
     * @param хранит ссылку на массив UserAction.
     */
    List<UserAction> actions = new ArrayList<>();

    /**
     * Метод для получения массива меню
     *
     * @return длина массива
     */
    public int getActionsLength() {
        return actions.size();
    }

    public void fillActions() {
        actions.add(new AddItem(0, "Add program"));
        actions.add(new AllItems(1, "Show all items"));
        actions.add(new UpdateItem(2, "Edit item"));
        actions.add(new DeleteItem(3, "Delete item"));
        actions.add(new FindItemById(4, "Find item by id"));
        actions.add(new FindItemsByName(5, "Find item by name"));
        actions.add(new ExitProgram(6, "Exit Program"));
    }

    public int select(int key) {

        actions.get(key).execute(input, tracker);

        return key;
    }

    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Конструктор
     *
     * @param input   Объект типа Input
     * @param tracker Объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }


}
