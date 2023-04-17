package less_01_15_04_23_hw;
//Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
// n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class less_01_hw_task_01 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner (System.in);
        System.out.printf("Введите натуральное число n: ");
        int n = iScanner.nextInt();
        iScanner.close();

        int summ = n * (n + 1) / 2;
        System.out.printf("%d-ое треугольное число = %d\n", n, summ);
        long f = 1;
        if( n > 20) {
            System.out.printf("Факториал числа %d вне диапазона типа 'long'\n", n);
        }
        else {
            for (int i = 1; i <= n; i++) {
                f = i * f;
            }
            System.out.printf("факториал числа %d = %d\n", n, f);
        }

    }
}
