package ru.job4j.tracker;

import ru.job4j.start.Input;

public class FindItemById implements UserAction {
    private static final String FIND_ID = "4";

    public FindItemById(int i, String a) {
    }

    @Override
    public int key() {
        return Integer.parseInt(FIND_ID);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заявки для удаления :");
        if (tracker.delete(id)) {
            System.out.println("------------------- Заявка найдена -----------------------");
            System.out.println("------------ Удаление заявки прошло успешно --------------");
        } else {
            System.out.println("------------ Заявка не найдена --------------");
        }
    }

    @Override
    public String info() {
        return "Find item by id.";
    }

}
