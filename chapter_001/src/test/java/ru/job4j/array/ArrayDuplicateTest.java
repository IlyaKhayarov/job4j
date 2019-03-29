package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Удаление дубликатов в массиве.=
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    /**
     * Test
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate dublicate = new ArrayDuplicate();
        String[] input = new String[]{"Привет", "Мир", "Супер", "Мир"};
        String[] resultArray = dublicate.remove(input);
        String[] expectArray = new String[]{"Привет", "Мир", "Супер"};
        assertThat(resultArray, arrayContainingInAnyOrder(expectArray));
    }

    /**
     * Test
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate2() {
        ArrayDuplicate dublicate = new ArrayDuplicate();
        String[] input = new String[]{"1", "1", "3", "2", "2", "4", "1", "3", "1", "2"};
        String[] resultArray = dublicate.remove(input);
        String[] expectArray = new String[]{"1", "2", "3", "4"};
        assertThat(resultArray, arrayContainingInAnyOrder(expectArray));
    }
}
