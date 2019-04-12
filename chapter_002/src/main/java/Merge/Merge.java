package Merge;
import java.util.Arrays;
/**
 * Объединить два массива
 *
 * @author Ilya Khayarov
 * @version $Id$
 * @since 0.1
 */

public class Merge {
    /**
     * Объединить два массива
     *
     * @param left  Массив 1
     * @param right Массив 2
     * @return Массив 3 (объединенный 1 и 2)
     */
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        System.arraycopy(left, 0, rsl, 0, left.length);
        System.arraycopy(right, 0, rsl, left.length, right.length);
        Arrays.sort(rsl);
        return rsl;
    }
}
