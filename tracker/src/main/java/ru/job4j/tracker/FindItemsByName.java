package ru.job4j.tracker;

import ru.job4j.start.Input;

public class FindItemsByName implements UserAction {
    private static String FIND_NAME;

    public FindItemsByName(int i, String a) {
        this.FIND_NAME = String.valueOf(i);
    }

    @Override
    public int key() {
        return Integer.parseInt(FIND_NAME);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки для поиска :");
        Item[] item = tracker.findByName(name);
        int j = 1;
        for (Item it : item) {
            if (item != null) {
                System.out.println("-----------------------------------------------------");
                System.out.printf("%-15s%-6s%-15s%-5s%n", "Номер заявки", "Имя", "Описание", "id");
                System.out.printf("%-15s%-6s%-15s%-5s%n", j, it.getName(), it.getDecs(), it.getId());
                System.out.println("-----------------------------------------------------");
                j++;
            }
        }
        System.out.println("------------ Ничего не найдено --------------");
    }


    @Override
    public String info() {
        return FIND_NAME + ". Find item by name.";
    }

}
