package ru.job4j.tracker;

import ru.job4j.start.Input;

public class FindItemById extends BaseAction {

    public FindItemById(int i, String a) {
        super(i, a);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заявки для поиска :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("----------------- Заявка найдена --------------------");
            System.out.println("-----------------------------------------------------");
            System.out.printf("%-15s%-6s%-15s%-5s%n", "Номер заявки", "Имя", "Описание", "id");
            System.out.printf("%-15s%-6s%-15s%-5s%n", item.getId(), item.getName(), item.getDecs(), item.getId());
            System.out.println("-----------------------------------------------------");
        } else {
            System.out.println("---------------- Заявка не найдена ------------------");
        }
    }
}
