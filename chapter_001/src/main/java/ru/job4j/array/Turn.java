package ru.job4j.array;

/**
 * Перевернуть массив.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Поворот.
     *
     * @param array Массив.
     * @return Повернутый массив.
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int n = array.length;
            int tmp = array[n - 1 - index];
            array[n - 1 - index] = array[index];
            array[index] = tmp;
        }
        return array;
    }
}
