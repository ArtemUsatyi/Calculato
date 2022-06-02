import java.io.IOException;
import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {

        int number1, number2, rezult;
        String rezultat;

        Scanner myscan = new Scanner(System.in);
        String number = myscan.nextLine();              //Сканируем строку

        String[] mas = number.split(" ");         // Разбиваем строку на отдельные символы, убираем пробелы и записываем в массив

        if ((mas.length < 3) || (mas.length > 4)) {         // Проверка Условия на количество чисел и операторов
            try {
                throw new IOException();
            }
            catch(IOException e) {
                System.out.println("Cтрока не является математической операцией");
            }
        }


        else if(mas.length == 3) {
            number1 = romanToNumber(mas[0]);            // Переводим с Римских цифр на Арабские
            number2 = romanToNumber(mas[2]);            // Переводим с Римских цифр на Арабские

            if (number1 > 0 && number2 > 0) {                // Проверка Условия на числа и символы

                rezult = calc(number1, number2, mas[1]);     // Вызываем метод Calc для выполнения операции с Арабскими числами

                if (rezult < 0) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("В римской системе нет отрицательных чисел");
                    }
                } else {
                    rezultat = numbertoRoman(rezult);            // Переводим числа с Арабских на Римские
                    System.out.println(rezultat);
                }
            }
            else {


                try {
                    int i = Integer.parseInt(mas[0].trim());        // Перевод символа из массива в целочисленное значение
                    int j = Integer.parseInt(mas[2].trim());        // Перевод символа из массива в целочисленное значение

                    if (i <= 10 && j <= 10) {
                        rezult = calc(i, j, mas[1]);
                        System.out.println(rezult);
                    } else System.out.println("Введите число в диапазоне от 0 до 10");

                } catch (NumberFormatException e) {
                    System.out.println("Используются одновременно разные системы счисления");
                }

            }
        }
    }

    public static int romanToNumber(String roman){         // метод перевода с Римских на Арабские
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }

    public static String numbertoRoman(int num){          // метод перевода с Арабских на Римские

        String [] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
                "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII","XLIII", "XLIV", "XLV", "XLVI",
                "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
                "LIX", "LX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C"};

        return roman [num];
    }


    public static int calc(int num1, int num2, String s){    // Метод вычисления операций чисел
        return switch (s) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }
}