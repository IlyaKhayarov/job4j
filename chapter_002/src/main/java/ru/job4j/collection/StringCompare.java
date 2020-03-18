package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int x = left.length();
        int y = right.length();
//        char[] leftArray = left.toCharArray();
//        char[] rightArray = right.toCharArray();
//        int x = leftArray.length;
//        int y = rightArray.length;
        int size = Math.min(x, y);
        int result;
        int r = 0;
        for (int i = 0; i < size; i++) {
            //result = Character.compare(leftArray[i], rightArray[i]);
            r = Character.compare(left.charAt(i), right.charAt(i));
//            result = Character.compare(left.charAt(i), right.charAt(i));
            if (r != 0) {
                result = r;
                break;
            }
//            if (result != 0) {
//                return result;
//            }
//            result = (r == 0) & (x != y) ? Integer.compare(x, y) : r;

        }
//        if (result == 0 & x != y) {
//            return Integer.compare(x, y);
//        }
//        if (r == 0 & x != y) {
//            result = Integer.compare(x, y);
//        }
        result = (r == 0) & (x != y) ? Integer.compare(x, y) : r;

        return result;
    }
}
