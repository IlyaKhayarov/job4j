package ru.job4j.condition;

/**
 * Программа максимум из двух чисел.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Максимальное значение.
     *
     * @param left Первое число.
     * @param right Второй число.
     * @return Возвращает максимальное значение.
     */
    public int max(int left, int right) {
        return left >= right ? left : right;
    }
}
