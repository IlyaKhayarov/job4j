package ru.job4j.tracker;

import ru.job4j.start.Input;

public class ExitProgram implements UserAction {
    private static String EXIT;

    public ExitProgram(int i, String a) {
        this.EXIT = String.valueOf(i);
    }

    @Override
    public int key() {
        return Integer.parseInt(EXIT);
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return EXIT + ". Exit Program.";
    }

}
