package less_01;
import java.util.Scanner;
public class iless_01_exp_input_data {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner (System.in);
        
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!\n", name);
        //iScanner.close();

        System.out.printf("int a: ");
        int x = iScanner.nextInt();
        System.out.printf("double a: ");
        double y = iScanner.nextDouble();
        System.out.printf("%d + %f = %f\n", x, y, x + y);
        
        System.out.printf("int a: ");
        boolean flag = iScanner.hasNextInt(); // проверка на валидность введенных данных (в данном случае на int)
        System.out.println(flag);
        int i = iScanner.nextInt();
        System.out.println(i);

        iScanner.close();
    }
}