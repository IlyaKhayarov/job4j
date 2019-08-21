package ru.job4j.Merge;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Объединить два массива
 *
 * @author Ilya Khayarov
 * @version $Id$
 * @since 0.1
 */
public class MergeTest {
    /**
     * 0х0.
     */
    @Test
    public void whenBothEmpty() {
        Merge algo = new Merge();
        int[] expect = new int[0];
        int[] result = algo.merge(
                new int[0],
                new int[0]
        );
        assertThat(result, is(expect));
    }

    /**
     * 2х2.
     */
    @Test
    public void whenAskOrder() {
        Merge algo = new Merge();
        int[] expect = {1, 2, 3, 4};
        int[] result = algo.merge(
                new int[]{1, 2},
                new int[]{3, 4}
        );
        assertThat(result, is(expect));
    }

    /**
     * 3х2.
     */
    @Test
    public void whenLeftLess() {
        Merge algo = new Merge();
        int[] expect = {1, 2, 3, 3, 4};
        int[] result = algo.merge(
                new int[]{1, 2, 3},
                new int[]{3, 4}
        );
        assertThat(result, is(expect));
    }

    /**
     * 2х3.
     */
    @Test
    public void whenLeftGreat() {
        Merge algo = new Merge();
        int[] expect = {1, 2, 3, 4, 4};
        int[] result = algo.merge(
                new int[]{1, 2},
                new int[]{3, 4, 4}
        );
        assertThat(result, is(expect));
    }

    /**
     * 0х4.
     */
    @Test
    public void whenLeftEmpty() {
        Merge algo = new Merge();
        int[] expect = {1, 3, 4, 4};
        int[] result = algo.merge(
                new int[]{},
                new int[]{1, 3, 4, 4}
        );
        assertThat(result, is(expect));
    }
    /**
     * 2х2.
     */
    @Test
    public void whenAskOrder2() {
        Merge algo = new Merge();
        int[] expect = {1, 2, 3, 4};
        int[] result = algo.merge(
                new int[]{1, 3},
                new int[]{2, 4}
        );
        assertThat(result, is(expect));
    }

}
