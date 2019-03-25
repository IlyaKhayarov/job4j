package ru.job4j.array;

/**
 * Поиск перебором.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class FindLoop {
    /**
     * Поиск.
     *
     * @param data Массив.
     * @param el Нужно найти значение.
     * @return Если значение найдено, вывод его, если нет, то -1.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
