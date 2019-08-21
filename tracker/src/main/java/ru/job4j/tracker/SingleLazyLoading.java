package ru.job4j.tracker;

public class SingleLazyLoading {
    private static SingleLazyLoading instance;

    private SingleLazyLoading() {}

    public static SingleLazyLoading getInstance() {
        if(instance == null) {
            instance = new SingleLazyLoading();
        }
        return instance;
    }
}
