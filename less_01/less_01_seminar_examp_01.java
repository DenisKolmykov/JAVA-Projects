package less_01;
// задана натуральная степень k
// Сформировать случайным образом список коэффициентов(значения от 0 до 100) многочлена (многочлен степени k)
// Пример: k=2 --> 2*x^2+4*x+5=0 или x^2+5=0 или 10*x^2 = 0

import java.util.Scanner;
import java.util.Random;

public class less_01_seminar_examp_01 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner (System.in);
        System.out.printf("Введите натуральную степень k: ");
        
        int k = iScanner.nextInt();
        String [] elem = new String [k];
        elem [k-1] = "x";
        int j = 0;
        while (j < k-1) {
            elem[j] = "x"+"^"+(k-j);
            j++;
        }
        
        Random rand = new Random();
        int r = 101;
        int [] coeff = new int [k+1];
        coeff [k] = rand.nextInt(r);
        String a = " + " + Integer.toString(coeff [k]);
        if (coeff [k] == 0) {
            a = "";
        }
    
        int i = 0;
        while (i < k) {
            coeff [i] = rand.nextInt(r);

            if (coeff [i] == 0) {
                elem [i] = "";
            }
            else if (coeff [i] != 1) {
                elem [i] = Integer.toString(coeff[i]) + elem [i];
            }
            i++;
        }

        String res = String.join(" + ",elem);
        System.out.println(res + a + " = 0");

        iScanner.close();
    }
}
