package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        int x = leftArray.length;
        int y = rightArray.length;
        int size = Math.min(x, y);
        int result = 0;
        for (int i = 0; i < size; i++) {
            result = Character.compare(leftArray[i], rightArray[i]);
            if (result != 0) {
                return result;
            }
        }
        if (result == 0 & x != y) {
            return Integer.compare(x, y);
        }
        return 0;
    }
}
