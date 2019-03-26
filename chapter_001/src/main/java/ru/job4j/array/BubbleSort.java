package ru.job4j.array;

/**
 * Алгоритм сортировки пузырьком.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Алгоритм сортировки пузырьком.
     *
     * @param array Массив.
     * @return Остсортированный массив.
     */
    public int[] sort(int[] array) {
        boolean b = false;
        while (!b) {
            b = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > (array[i + 1])) {
                    b = false;
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        return array;
    }
}
