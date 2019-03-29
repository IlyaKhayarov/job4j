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
        int g = array.length - 1;
        for (int z = g; z >= 1; z--) {
            for (int i = 0; i < g; i++) {
                if (array[i] > (array[i + 1])) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        return array;
    }
}
