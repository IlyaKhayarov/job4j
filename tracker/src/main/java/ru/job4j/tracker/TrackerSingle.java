package ru.job4j.tracker;

public class TrackerSingle {

    private TrackerSingle() {}

    private static final class Holder {
        private static final TrackerSingle INSTANCE = new TrackerSingle();
    }

    public static TrackerSingle getInstance() {
        return Holder.INSTANCE;
    }

}
