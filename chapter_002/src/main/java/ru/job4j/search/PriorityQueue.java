package ru.job4j.search;

import java.util.Collections;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        tasks.add(task);
        TaskSort taskSort = new TaskSort();
        Collections.sort(tasks, taskSort);
    }

    public Task take() {
        return this.tasks.poll();
    }
}

