package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаление дубликатов в массиве.=
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {

    /**
     * Алгоритм сортировки пузырьком.
     *
     * @param array Массив.
     * @return Массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int len = array.length;
        for (int out = 0; out < len; out++) {
            for (int in = out + 1; in < len; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[len - 1];
                    len--;
                    in--;
                }

            }
        }
        return Arrays.copyOf(array, len);
    }
}
