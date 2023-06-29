package Calc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                Object[] obj = getParams();

                if ((char) obj[1] == 'q') {
                    break;
                }

                if ((char) obj[1] == '/' && (int) obj[2] == 0) {
                    System.out.println("На ноль делить нельзя!");
                    continue;
                }

                System.out.printf("%.2f%n", getResult((int) obj[0], (int) obj[2], (char) obj[1]));
            } catch (InputMismatchException ex) {
                System.out.println("Wrong input data!");
            }
        }
    }

    private static Object[] getParams() {
        Object[] obj = new Object[3];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        obj[0] = scanner.nextInt();
        System.out.println("Введите символ арифметической операции (для выхода из калькулятора введите q):");
        obj[1] = scanner.next().charAt(0);

        if ((char) obj[1] != '!' && (char) obj[1] != 'q') {
            System.out.println("Enter second number:");
            obj[2] = scanner.nextInt();
        } else {
            obj[2] = 0;
        }

        return obj;
    }

    private static double getResult (int firstNumber, int secondNumber, char operation) {
        switch (operation) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return (double) firstNumber / secondNumber;
            case '!':
                return fact(firstNumber);
            default:
                return 0;
        }
    }

    private static int fact(int numberOne) {
        int res = 1;
        for (int i = 1; i <= numberOne; i++) {
            res *= i;
        }
        return res;
    }
}
