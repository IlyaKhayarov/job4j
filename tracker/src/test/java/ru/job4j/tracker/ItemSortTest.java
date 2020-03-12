package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemSortTest {
    @Test
    public void whenSortAsc() {
        List<Item> list = Arrays.asList(
                new Item("Impl task", "Task impl", 2),
                new Item("Fix bugs", "Bugs fix", 4),
                new Item("Reboot server", "Server reboot", 1)
        );
        Collections.sort(list, new ItemAsc());
        List<Item> result = Arrays.asList(
                new Item("Fix bugs", "Bugs fix", 4),
                new Item("Impl task", "Task impl", 2),
                new Item("Reboot server", "Server reboot", 1)
        );
        assertThat(list, is(result));
    }
    @Test
    public void whenSortDesc() {
        List<Item> list = Arrays.asList(
                new Item("Impl task", "Task impl", 2),
                new Item("Fix bugs", "Bugs fix", 4),
                new Item("Reboot server", "Server reboot", 1)
        );
        Collections.sort(list, new ItemDesc());
        List<Item> result = Arrays.asList(
                new Item("Reboot server", "Server reboot", 1),
                new Item("Impl task", "Task impl", 2),
                new Item("Fix bugs", "Bugs fix", 4)
        );
        assertThat(list, is(result));
    }
}
