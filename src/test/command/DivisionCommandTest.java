package test.command;

import command.DivisionCommand;
import core.Command;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivisionCommandTest {

    @Test
    public void testDivisionPositiveNumbers() {
        Command divisionCommand = new DivisionCommand();
        int result = divisionCommand.execute(10, 2);
        assertEquals(5, result);
    }

    @Test
    public void testDivisionByOne() {
        Command divisionCommand = new DivisionCommand();
        int result = divisionCommand.execute(7, 1);
        assertEquals(7, result);
    }

    @Test
    public void testDivisionResultingInZero() {
        Command divisionCommand = new DivisionCommand();
        int result = divisionCommand.execute(0, 5);
        assertEquals(0, result);
    }

    @Test
    public void testDivisionByNegativeNumber() {
        Command divisionCommand = new DivisionCommand();
        int result = divisionCommand.execute(10, -2);
        assertEquals(-5, result);
    }

    @Test
    public void testDivisionByZeroThrowsException() {
        Command divisionCommand = new DivisionCommand();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            divisionCommand.execute(5, 0);
        });
        assertEquals("Деление на ноль невозможно.", exception.getMessage());
    }
}

