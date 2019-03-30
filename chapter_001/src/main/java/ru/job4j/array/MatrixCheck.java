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
        for (int i = 1; i < data.length; i++) {
                if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
                if (data[0][2] != data[0][i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
