package ru.job4j.array;

/**
 * Двумерный массив. Таблица умножения.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    /**
     * Таблица умножения.
     *
     * @param size размер.
     * @return Перемноженные числа.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int a = 0; a < table.length; a++) {
            for (int i = 0; i < table.length; i++) {
                table[i][a] = (i + 1) * (a + 1);
            }
        }
        return table;
    }
}
