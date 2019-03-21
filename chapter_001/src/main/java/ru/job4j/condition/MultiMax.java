package ru.job4j.condition;

/**
 * Программа максимум из трех чисел.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MultiMax {
    /**
     * Максимальное значение.
     *
     * @param first Первое число.
     * @param second Второй число.
     * @param third Третье число.
     * @return Возвращает максимальное значение.
     */
    public int max(int first, int second, int third) {

            int result = first > second ? first : second;
            if (third > result) {
                result = third;
            }
            return result;
    }
}
