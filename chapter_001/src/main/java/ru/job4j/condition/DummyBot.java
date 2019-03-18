package ru.job4j.condition;

/**
 * Программа "Глупый бот".
 *
 * @author Ilya Khayarov (ilya.ssb.ru@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class DummyBot {
    /**
     * Отвечает на вопросы
     *
     * @param question Вопрос от клиента
     * @return Ответ
     */
    public String answer(String question) {
        String rls = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rls = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rls = "До скорой встречи.";
        }
        return rls;
    }
}
