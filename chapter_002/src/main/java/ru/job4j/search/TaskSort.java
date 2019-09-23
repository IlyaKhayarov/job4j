package ru.job4j.search;

import java.util.Comparator;

public class TaskSort implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getPriority() == o2.getPriority()) {
            return 0;
        } else if (o1.getPriority() > o2.getPriority()) {
            return 1;
        } else {
            return -1;
        }
    }
}
