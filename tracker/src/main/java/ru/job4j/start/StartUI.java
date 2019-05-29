package ru.job4j.start;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class StartUI {

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private static final String ADD = "0";
    private static final String ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";
    private static final String EXIT = "6";

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (ALL.equals(answer)) {
                this.allItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ID.equals(answer)) {
                this.findIdItem();
            } else if (FIND_NAME.equals(answer)) {
                this.findNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + " -----------");
    }

    private void allItem() {
        System.out.println("------------ Вывод всех заявок --------------");
        int j = 1;
        for (Item item : this.tracker.findAll()) {
            System.out.println("-----------------------------------------------------");
            System.out.printf("%-15s%-6s%-15s%-5s%n", "Номер заявки", "Имя", "Описание", "id");
            System.out.printf("%-15s%-6s%-15s%-5s%n", j, item.getName(), item.getDecs(), item.getId());
            System.out.println("-----------------------------------------------------");
            /*System.out.println("Заявка номер " + j + "\n" +
                                "Имя - " + item.getName() + "\n" +
                                    "Описание - " + item.getDecs() + "\n" +
                                        "id - " + item.getId() + "\n"
            );*/
            j++;
        }
    }

    private void editItem() {
        String id = this.input.ask("Введите id заявки для поиска :");
        Item item = this.tracker.findById(id);
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item2 = new Item(name, desc, System.currentTimeMillis());
        if (item != null) {
            System.out.println("------------------- Заявка найдена ---------------------");
            this.tracker.replace(id, item2);
            System.out.println("------------ Замена заявки прошла успешно --------------");
        } else {
            System.out.println("------------ Заявка не найдена --------------");
        }
    }

    private void deleteItem() {
        String id = this.input.ask("Введите id заявки для удаления :");
        if (this.tracker.delete(id)) {
            System.out.println("------------------- Заявка найдена -----------------------");
            System.out.println("------------ Удаление заявки прошло успешно --------------");
        } else {
            System.out.println("------------ Заявка не найдена --------------");
        }
    }

    private void findIdItem() {
        String id = this.input.ask("Введите id заявки для поиска :");
        Item item = this.tracker.findById(id);
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

    private void findNameItem() {
        String name = input.ask("Введите имя заявки для поиска :");
        Item[] item = this.tracker.findByName(name);
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

    private void showMenu() {
        System.out.println("Меню. ");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
