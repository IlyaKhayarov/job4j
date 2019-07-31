package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.start.StubInput;
import ru.job4j.start.ValidateInput;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Khayarov Ilya
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final PrintStream out = System.out;
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(new PrintStream(this.out));
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        List<Integer> l = new ArrayList<>();
        l.add(1);
        input.ask("Enter", l);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter validate data again.%n")
                )
        );
    }

    @Test
    public void whenInvalidInput2() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"7", "1"})
        );
        List<Integer> l = new ArrayList<>();
        l.add(1);
        input.ask("Enter", l);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please select key from menu.%n")
                )
        );
    }
}
