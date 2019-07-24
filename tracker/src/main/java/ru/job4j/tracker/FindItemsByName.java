package ru.job4j.tracker;

import ru.job4j.start.Input;

public class FindItemsByName implements UserAction {
    private static final String FIND_ID = "5";

    public FindItemsByName(int i, String a) {
    }

    @Override
    public int key() {
        return Integer.parseInt(FIND_ID);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки для поиска :");
        Item[] item = tracker.findByName(name);
        int j = 1;
        if (item[0] != null) {
            System.out.println("------------ Поиск закончен --------------");
            for (Item it : item) {
                System.out.println("-----------------------------------------------------");
                System.out.printf("%-15s%-6s%-15s%-5s%n", "Номер заявки", "Имя", "Описание", "id");
                System.out.printf("%-15s%-6s%-15s%-5s%n", j, it.getName(), it.getDecs(), it.getId());
                System.out.println("-----------------------------------------------------");
                j++;
            }
        } else {
            System.out.println("------------ Ничего не найдено --------------");
        }
    }

    @Override
    public String info() {
        return "Find item by name.";
    }

}
