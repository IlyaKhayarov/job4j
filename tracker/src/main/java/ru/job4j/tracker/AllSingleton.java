package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class AllSingleton {
    public List acr = new ArrayList<>();

    public void fill() {
        acr.add(EnumEagerLoading.INSTANCE);
        acr.add(SingleLazyLoading.getInstance());
        acr.add(EagerLoading.getInstance());
        acr.add(TrackerSingle.getInstance());
    }
}
