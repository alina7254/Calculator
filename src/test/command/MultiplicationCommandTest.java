package test.command;

import command.MultiplicationCommand;
import core.Command;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationCommandTest {

    @Test
    public void testMultiplicationPositiveNumbers() {
        Command multiplicationCommand = new MultiplicationCommand();
        int result = multiplicationCommand.execute(4, 3);
        assertEquals(12, result);
    }

    @Test
    public void testMultiplicationWithZero() {
        Command multiplicationCommand = new MultiplicationCommand();
        int result = multiplicationCommand.execute(5, 0);
        assertEquals(0, result);
    }

    @Test
    public void testMultiplicationWithNegativeNumber() {
        Command multiplicationCommand = new MultiplicationCommand();
        int result = multiplicationCommand.execute(-3, 5);
        assertEquals(-15, result);
    }
}

