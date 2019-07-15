package ru.job4j.Strategy;

/**
 * @author khayarov-ir
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder build = new StringBuilder();
        build.append(" ***********\n");
        build.append(" *         *\n");
        build.append(" *         *\n");
        build.append(" *         *\n");
        build.append(" ***********");
        return build.toString();
    }
}
