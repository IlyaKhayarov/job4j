package ru.job4j.Strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    // поле содержит дефолтный вывод в консоль
    private final PrintStream stdout = System.out;

    // буфер для результата
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {

        System.out.println("execute before method");

        System.setOut(new PrintStream(out));

    }

    @After
    public void backOutput() {

        System.out.println("execute after method");

        System.setOut(stdout);

    }

    @Test
    public void whenDrawSquare() {
        // выполняем действия пишущее в консоль
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()), is(
                        new StringBuilder()
                                .append(" ***********\n")
                                .append(" *         *\n")
                                .append(" *         *\n")
                                .append(" *         *\n")
                                .append(" ***********")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("      *      \n")
                                .append("     * *     \n")
                                .append("    *   *    \n")
                                .append("   *     *   \n")
                                .append("  *       *  \n")
                                .append(" *********** ")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

}
