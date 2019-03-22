package ru.job4j.loop;

/**
 * Шахматная доска в псевдографике.
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * Доска с заполнением.
     *
     * @param width Ширина.
     * @param height Высота.
     * @return Возвращает строку, представляющую данные в этой строке.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    // условие проверки, что писать пробел или X
                    if ((i + j) % 2 == 0) {
                        screen.append("x");
                    } else {
                        // перевод на новую строку.
                        screen.append(" ");
                    }
                }
                screen.append(ln);
            }
            return screen.toString();
    }
}
