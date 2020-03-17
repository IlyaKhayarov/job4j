package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person z : persons) {
            if (z.getAddress().contains(key)
                    || z.getName().contains(key)
                    || z.getSurname().contains(key)
                    || z.getPhone().contains(key)) {
                result.add(z);
            }
        }

        return result;
    }

}
