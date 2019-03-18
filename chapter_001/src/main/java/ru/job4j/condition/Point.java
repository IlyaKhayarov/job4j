package ru.job4j.condition;

/**
 * Программа расчета расстояния методу точками в системе координат.
 */
public class Point {

    /**
     * Расстояние.
     *
     * @param x1 координата 1
     * @param y1 координата 2
     * @param x2 координата 3
     * @param y2 координата 4
     * @return Расстояние методу точками.
     */
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
