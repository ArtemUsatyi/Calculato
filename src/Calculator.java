import java.io.IOException;
import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {

        int number1, number2, rezult;
        String rezultat;

        Scanner myscan = new Scanner(System.in);
        String number = myscan.nextLine();              //��������� ������

        String[] mas = number.split(" ");         // ��������� ������ �� ��������� �������, ������� ������� � ���������� � ������

        if ((mas.length < 3) || (mas.length > 4)) {         // �������� ������� �� ���������� ����� � ����������
            try {
                throw new IOException();
            }
            catch(IOException e) {
                System.out.println("C����� �� �������� �������������� ���������");
            }
        }


        else if(mas.length == 3) {
            number1 = romanToNumber(mas[0]);            // ��������� � ������� ���� �� ��������
            number2 = romanToNumber(mas[2]);            // ��������� � ������� ���� �� ��������

            if (number1 > 0 && number2 > 0) {                // �������� ������� �� ����� � �������

                rezult = calc(number1, number2, mas[1]);     // �������� ����� Calc ��� ���������� �������� � ��������� �������

                if (rezult < 0) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("� ������� ������� ��� ������������� �����");
                    }
                } else {
                    rezultat = numbertoRoman(rezult);            // ��������� ����� � �������� �� �������
                    System.out.println(rezultat);
                }
            }
            else {


                try {
                    int i = Integer.parseInt(mas[0].trim());        // ������� ������� �� ������� � ������������� ��������
                    int j = Integer.parseInt(mas[2].trim());        // ������� ������� �� ������� � ������������� ��������

                    if (i <= 10 && j <= 10) {
                        rezult = calc(i, j, mas[1]);
                        System.out.println(rezult);
                    } else System.out.println("������� ����� � ��������� �� 0 �� 10");

                } catch (NumberFormatException e) {
                    System.out.println("������������ ������������ ������ ������� ���������");
                }

            }
        }
    }

    public static int romanToNumber(String roman){         // ����� �������� � ������� �� ��������
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

    public static String numbertoRoman(int num){          // ����� �������� � �������� �� �������

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


    public static int calc(int num1, int num2, String s){    // ����� ���������� �������� �����
        return switch (s) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }
}