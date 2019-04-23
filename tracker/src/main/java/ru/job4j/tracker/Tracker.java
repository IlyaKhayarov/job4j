package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
}
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.length; i++) {
            if(item.getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }
    public boolean delete(String id) {
        int j = 0;
        boolean result = false;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                this.position = j;
                break;
            }
        }
        for(int k = j; k < items.length - 1; k++) {
            items[k] = items[k + 1];
            position--;
        }
        System.arraycopy(items, 0, items, 0, position);
        result = true;
        return result;
    }
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for(int i = 0; i < this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
    public Item[] findByName(String key) {
        Item[] result = null;
        int j = 0;
        for(Item item : items) {
            if (item.getName().equals(key)) {
                j++;
                System.arraycopy(items, 0, result, 0, j);
            }
        }
        return result;
    }
    public Item findById(String id) {
        Item result = null;
        for(Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }


}
