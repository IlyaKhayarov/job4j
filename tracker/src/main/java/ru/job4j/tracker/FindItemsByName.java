package ru.job4j.tracker;

import ru.job4j.start.Input;

import java.util.List;

public class FindItemsByName extends BaseAction {

    public FindItemsByName(int i, String a) {
        super(i, a);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки для поиска :");
        List<Item> item = tracker.findByName(name);
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
        System.out.println("------------------ Поиск закончен -------------------");
    }
}
