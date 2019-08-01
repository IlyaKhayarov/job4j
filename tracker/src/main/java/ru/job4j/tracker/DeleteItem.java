package ru.job4j.tracker;

import ru.job4j.start.Input;

public class DeleteItem extends BaseAction {


    public DeleteItem(int i, String a) {
        super(i, a);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заявки для удаления :");
        if (tracker.delete(id)) {
            System.out.println("----------------- Заявка найдена --------------------");
            System.out.println("---------- Удаление заявки прошло успешно -----------");
        } else {
            System.out.println("---------------- Заявка не найдена -------------------");
        }
    }
}
