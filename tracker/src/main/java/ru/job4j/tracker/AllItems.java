package ru.job4j.tracker;

import ru.job4j.start.Input;

public class AllItems extends BaseAction {

    public AllItems(int i, String a) {
        super(i, a);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("----------------- Вывод всех заявок -----------------");
        int j = 1;
        for (Item item : tracker.findAll()) {
            System.out.println("-----------------------------------------------------");
            System.out.printf("%-15s%-6s%-15s%-5s%n", "Номер заявки", "Имя", "Описание", "id");
            System.out.printf("%-15s%-6s%-15s%-5s%n", j, item.getName(), item.getDecs(), item.getId());
            System.out.println("-----------------------------------------------------");
            j++;
        }
    }
}
