package ru.job4j.strategy;

/**
 * @author khayarov-ir
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder build = new StringBuilder();
        build.append("      *      \n");
        build.append("     * *     \n");
        build.append("    *   *    \n");
        build.append("   *     *   \n");
        build.append("  *       *  \n");
        build.append(" *********** ");
        return String.valueOf(build);
    }
}
