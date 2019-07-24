package ru.job4j.tracker;

import ru.job4j.start.Input;

public interface UserAction {
    /**
     * Метод возвращает ключ опции
     *
     * @retutn ключ
     */
    int key();

    /**
     * Основной метод
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню
     *
     * @return Строка меню
     */
    String info();
}
