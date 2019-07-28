package ru.job4j.tracker;

import ru.job4j.start.Input;

public class DeleteItem implements UserAction {
    private static String DEL;

    public DeleteItem(int i, String a) {
        this.DEL = String.valueOf(i);
    }

    @Override
    public int key() {
        return Integer.parseInt(DEL);
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
        return DEL + ". Delete item.";
    }

}
