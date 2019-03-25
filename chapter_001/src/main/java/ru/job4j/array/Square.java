package ru.job4j.array;

/**
 * Массив в степени.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * Массив в квадрате.
     *
     * @param bound Параметр.
     * @return Возвращает массив в квадрате.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = i + 1;
            rst[i] *= rst[i];
        }
        return rst;
    }
}