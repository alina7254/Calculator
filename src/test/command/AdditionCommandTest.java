package test.command;

import command.AdditionCommand;
import core.Command;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdditionCommandTest {

    @Test
    public void testAdditionPositiveNumbers() {
        Command additionCommand = new AdditionCommand();
        int result = additionCommand.execute(3, 5);
        assertEquals(8, result);
    }

    @Test
    public void testAdditionWithZero() {
        Command additionCommand = new AdditionCommand();
        int result = additionCommand.execute(5, 0);
        assertEquals(5, result);
    }

    @Test
    public void testAdditionNegativeNumbers() {
        Command additionCommand = new AdditionCommand();
        int result = additionCommand.execute(-3, -7);
        assertEquals(-10, result);
    }
}
