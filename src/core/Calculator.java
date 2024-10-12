package core;

import command.AdditionCommand;
import command.DivisionCommand;
import command.MultiplicationCommand;
import command.SubtractionCommand;
import converter.RomanNumeralConverter;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final Map<String, Command> commands = new HashMap<>();

    public Calculator() {
        commands.put("+", new AdditionCommand());
        commands.put("-", new SubtractionCommand());
        commands.put("*", new MultiplicationCommand());
        commands.put("/", new DivisionCommand());
    }

    public String calculate(String num1Str, String num2Str, String operator) {
        boolean isRoman = RomanNumeralConverter.isRoman(num1Str) && RomanNumeralConverter.isRoman(num2Str);

        int num1, num2;
        if (isRoman) {
            num1 = RomanNumeralConverter.toArabic(num1Str);
            num2 = RomanNumeralConverter.toArabic(num2Str);
        } else {
            num1 = parseArabic(num1Str);
            num2 = parseArabic(num2Str);
        }

        if (operator.equals("/") && num2 == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Число должно быть в пределах от 1 до 10.");
        }

        Command command = commands.get(operator);
        if (command == null) {
            throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }

        int result = command.execute(num1, num2);

        if (isRoman) {
            if (result <= 0) {
                throw new IllegalArgumentException("Римские числа не могут быть отрицательными или равны нулю.");
            }
            return RomanNumeralConverter.toRoman(result);
        } else {
            return String.valueOf(result);
        }
    }

    private int parseArabic(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат числа.");
        }
    }


}


