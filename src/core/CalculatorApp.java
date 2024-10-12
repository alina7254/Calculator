package core;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Введите выражение (например, 2 + 3 или IV * VI): ");
        String input = scanner.nextLine().trim();

        try {
            String[] tokens = input.split(" ");
            if (tokens.length != 3) {
                throw new IllegalArgumentException("Некорректный формат. Используйте формат: число операция число");
            }

            String num1Str = tokens[0];
            String num2Str = tokens[2];
            String operator = tokens[1];

            String result = calculator.calculate(num1Str, num2Str, operator);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}


