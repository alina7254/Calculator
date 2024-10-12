package converter;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {
    private static final Map<String, Integer> romanToArabic = new HashMap<>();
    private static final String[] arabicToRoman = {
            "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
    };

    static {
        romanToArabic.put("I", 1);
        romanToArabic.put("II", 2);
        romanToArabic.put("III", 3);
        romanToArabic.put("IV", 4);
        romanToArabic.put("V", 5);
        romanToArabic.put("VI", 6);
        romanToArabic.put("VII", 7);
        romanToArabic.put("VIII", 8);
        romanToArabic.put("IX", 9);
        romanToArabic.put("X", 10);
    }

    public static int toArabic(String roman) {
        if (!romanToArabic.containsKey(roman)) {
            throw new IllegalArgumentException("Неверный формат числа.");
        }
        return romanToArabic.get(roman);
    }

    public static String toRoman(int number) {
        if (number <= 0 || number >= arabicToRoman.length) {
            throw new IllegalArgumentException("Римские числа могут быть только от 1 до 10.");
        }
        return arabicToRoman[number];
    }

    public static boolean isRoman(String value) {
        return romanToArabic.containsKey(value);
    }
}

