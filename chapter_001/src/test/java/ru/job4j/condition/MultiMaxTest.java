package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test максимум из трех чисел.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MultiMaxTest {
    /**
     * Первое число > второго и третьего
     */
    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(4, 1, 2);
        assertThat(result, is(4));

    }
    /**
     * Второе число > первого и третьего
     */
    @Test
    public void whenSecondMax() {

        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }
    /**
     * Третье число > первого и второго
     */
    @Test
    public void whenThirdMax() {

        MultiMax check = new MultiMax();
        int result = check.max(1, 2, 4);
        assertThat(result, is(4));
    }
}
