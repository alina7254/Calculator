package test.command;

import command.SubtractionCommand;
import core.Command;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubtractionCommandTest {

    @Test
    public void testSubtractionPositiveNumbers() {
        Command subtractionCommand = new SubtractionCommand();
        int result = subtractionCommand.execute(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testSubtractionWithZero() {
        Command subtractionCommand = new SubtractionCommand();
        int result = subtractionCommand.execute(5, 0);
        assertEquals(5, result);
    }

    @Test
    public void testSubtractionResultingInNegative() {
        Command subtractionCommand = new SubtractionCommand();
        int result = subtractionCommand.execute(4, 10);
        assertEquals(-6, result);
    }
}
