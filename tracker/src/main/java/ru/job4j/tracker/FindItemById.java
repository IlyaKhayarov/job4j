package ru.job4j.tracker;

import ru.job4j.start.Input;

public class FindItemById implements UserAction {
    private static String FIND_ID;

    public FindItemById(int i, String a) {
        this.FIND_ID = String.valueOf(i);
    }

    @Override
    public int key() {
        return Integer.parseInt(FIND_ID);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id заявки для поиска :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("------------ Заявка найдена --------------");
            System.out.println("-----------------------------------------------------");
            System.out.printf("%-15s%-6s%-15s%-5s%n", "Номер заявки", "Имя", "Описание", "id");
            System.out.printf("%-15s%-6s%-15s%-5s%n", item.getId(), item.getName(), item.getDecs(), item.getId());
            System.out.println("-----------------------------------------------------");
        } else {
            System.out.println("------------ Заявка не найдена --------------");
        }
    }

    @Override
    public String info() {
        return FIND_ID + ". Find item by id.";
    }

}
