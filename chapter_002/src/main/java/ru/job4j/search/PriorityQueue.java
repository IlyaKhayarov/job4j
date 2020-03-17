package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int size = tasks.size();
        int g = 0;
        if (size == 0) {
            tasks.add(task);
        } else {
            for (int i = 0; i < size; i++) {
                if (task.getPriority() < tasks.get(i).getPriority()) {
                    tasks.add(g, task);
                    break;
                } else {
                    g++;
                    if (g == size) {
                        tasks.add(task);
                    }
                }
            }

        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}

