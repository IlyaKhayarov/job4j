package ru.job4j.array;

/**
 * Квадратный массив заполнен true или false по диагоналям.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Квадратный массив заполнен true или false по диагоналям.
     *
     * @param data Массив.
     * @return True или false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int z = data.length / 2 + 1;
        boolean b = data[z][z];
        for (int i = 0; i < data.length; i += 2) {
                if (data[i][0] != b || data[0][i] != b) {
                    result = false;
                    break;
            }
        }
        return result;
    }
}
