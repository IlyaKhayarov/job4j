package ru.job4j.tracker;

public class EagerLoading {
    private static final EagerLoading INSTANCE = new EagerLoading();

    private EagerLoading() {}

    public static EagerLoading getInstance() {
        return INSTANCE;
    }
}
