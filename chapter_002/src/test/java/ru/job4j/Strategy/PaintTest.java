package ru.job4j.Strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // создаем буфер для хранения вывода
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // заменяем стандартный вывод на вывод в память для тестирования
        System.setOut(new PrintStream(out));
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
        // возвращаем обратно стандартный вывод в консоль
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()), is(
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
        System.setOut(stdout);


    }
}
