package ru.job4j.loop;

/**
 * Программа сумма четных чисел.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Сумма четных чисел.
     *
     * @param start Начальное значение.
     * @param finish Конечное значение.
     * @return Возвращает сумму четных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
