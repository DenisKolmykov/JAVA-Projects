package less_01_15_04_23_hw;
// Реализовать простой калькулятор

import java.util.Scanner;

public class less_01_hw_task_03 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner (System.in);
        // System.out.printf("Введите математическую операцию (+ - * /): ");
        // String operation = iScanner.nextLine();
        
        System.out.print("Введите первое число (num1): ");
        String temp = iScanner.nextLine();
        float num1 = Float.parseFloat(temp);

        System.out.printf("Введите математическую операцию (+ - * /): ");
        String operation = iScanner.nextLine();

        System.out.printf("Введите второе число (num2): ");
        float num2 = iScanner.nextInt();
        iScanner.close();
        
        float res = 0;
        boolean flag = true;

        if (operation.equals("*")) {
            res = num1 * num2;
        }

        else if (operation.equals("+")) {
            res = num1 + num2;
        }

        else if (operation.equals("-")) {
            res = num1 - num2;
        }

        else if (operation.equals("/")) {
            if (num2 == 0) {
                System.out.println("Вы пытаетесь делить на ноль!!!");
                flag = false;
            }
            else {
                res = num1 / num2;
            }
        }
        else {
            flag = false;
        }

        if (flag) {
            System.out.printf("%.2f %s %.2f = %.2f\n", num1, operation, num2,res);
        }
        else {
            System.out.println("Введены не корректные данные для осуществления математической операции");
        }
    }
}
