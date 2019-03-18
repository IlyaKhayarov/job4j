package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test максимум из двух чисел.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    /**
     * Второе число > первого
     */
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Первое число > второго
     */
    @Test
    public void whenMax2To1Then1() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }
    /**
     * Первое число = второму
     */
    @Test
    public void whenMax1To1Then1() {
        Max max = new Max();
        int result = max.max(1, 1);
        assertThat(result, is(1));
    }
    /**
     * Первое число = второму
     */
    @Test
    public void whenMax2To2Then2() {
        Max max = new Max();
        int result = max.max(2, 2);
        assertThat(result, is(2));
    }
}
