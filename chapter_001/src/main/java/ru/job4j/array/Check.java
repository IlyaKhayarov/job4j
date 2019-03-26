package ru.job4j.array;

/**
 * Массив заполнен true или false.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * Массив заполнен true или false.
     *
     * @param data Массив.
     * @return True или false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean b = data[0];
        for (boolean i : data) {
            if (i != b) {
                result = false;
                break;
            }
        }
        return result;
    }
}
