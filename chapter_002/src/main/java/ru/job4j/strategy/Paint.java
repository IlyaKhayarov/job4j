package ru.job4j.strategy;

/**
 * @author khayarov-ir
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    public static void main(String[] args) {
        draw(new Triangle());
        //draw(new Square());
    }

    public static void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
