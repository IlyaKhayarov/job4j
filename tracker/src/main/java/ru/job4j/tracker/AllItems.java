package ru.job4j.tracker;

import ru.job4j.start.Input;

public class AllItems implements UserAction {
    private static final String ALL = "1";

    public AllItems(int i, String a) {
    }

    @Override
    public int key() {
        return Integer.parseInt(ALL);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Вывод всех заявок --------------");
        int j = 1;
        for (Item item : tracker.findAll()) {
            System.out.println("-----------------------------------------------------");
            System.out.printf("%-15s%-6s%-15s%-5s%n", "Номер заявки", "Имя", "Описание", "id");
            System.out.printf("%-15s%-6s%-15s%-5s%n", j, item.getName(), item.getDecs(), item.getId());
            System.out.println("-----------------------------------------------------");
            j++;
        }
    }

    @Override
    public String info() {
        return "All Items.";
    }

}
