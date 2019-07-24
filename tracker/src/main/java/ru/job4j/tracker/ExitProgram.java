package ru.job4j.tracker;

import ru.job4j.start.Input;

public class ExitProgram implements UserAction {
    private static final String EXIT = "6";

    public ExitProgram(int i, String a) {
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
        return "Exit Program.";
    }

}
