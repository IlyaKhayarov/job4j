package ru.job4j.loop;

/**
 * Программа вычисляющая факториал.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Факториал от числа.
     *
     * @param n Число.
     * @return Возвращает факториал числа n.
     */
    public int calc(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                i = 1;
                result = 1;
            }
            result = result * i;
        }
        return result;
    }
}
