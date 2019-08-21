package ru.job4j.start;

import java.util.List;

public abstract class Ask implements Input{


    public abstract String ask(String question);

    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}
