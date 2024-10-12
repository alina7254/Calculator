package test;

import core.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {

    private final Calculator calculator = new Calculator();


    @Test
    public void testAdditionArabic() {
        String result = calculator.calculate("3", "5", "+");
        assertEquals("8", result);
    }


    @Test
    public void testSubtractionArabic() {
        String result = calculator.calculate("10", "4", "-");
        assertEquals("6", result);
    }


    @Test
    public void testMultiplicationArabic() {
        String result = calculator.calculate("2", "3", "*");
        assertEquals("6", result);
    }


    @Test
    public void testDivisionArabic() {
        String result = calculator.calculate("8", "2", "/");
        assertEquals("4", result);
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("8", "0", "/");
        });
        assertEquals("Деление на ноль невозможно.", exception.getMessage());
    }

    @Test
    public void testAdditionRoman() {
        String result = calculator.calculate("III", "V", "+");
        assertEquals("VIII", result);
    }

    @Test
    public void testSubtractionRoman() {
        String result = calculator.calculate("X", "II", "-");
        assertEquals("VIII", result);
    }

    @Test
    public void testMultiplicationRoman() {
        String result = calculator.calculate("IV", "II", "*");
        assertEquals("VIII", result);
    }

    @Test
    public void testDivisionRoman() {
        String result = calculator.calculate("VI", "II", "/");
        assertEquals("III", result);
    }

    @Test
    public void testInvalidOperator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("3", "5", "%");
        });
        assertEquals("Неподдерживаемая операция: %", exception.getMessage());
    }

    @Test
    public void testNegativeResultForRoman() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("II", "V", "-");
        });
        assertEquals("Римские числа не могут быть отрицательными или равны нулю.", exception.getMessage());
    }

    @Test
    public void testInvalidRomanInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("XI", "V", "+");
        });
        assertEquals("Неверный формат числа.", exception.getMessage());
    }

    @Test
    public void testOutOfRangeArabicInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("11", "2", "+");
        });
        assertEquals("Число должно быть в пределах от 1 до 10.", exception.getMessage());
    }
}


