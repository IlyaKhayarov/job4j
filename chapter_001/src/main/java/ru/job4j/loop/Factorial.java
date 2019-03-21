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
     * @param n Число.
     * @return Возвращает факториал числа n.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
