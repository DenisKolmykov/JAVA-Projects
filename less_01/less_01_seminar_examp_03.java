package less_01;

// дан массив двоичных чисел {1,1,0,0,1,0} вывести максивамальное количество подряд идущих 1
import java.util.Random;

public class less_01_seminar_examp_03 {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 6;
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr [i] = rand.nextInt(2);
            System.out.println(arr [i]);
        }
        //System.out.println(arr);
        
        int maxCount = 0;
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (arr [j] == 1) {
                count ++;
            }
            else {
                if (maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        if (maxCount < count) {
            maxCount = count;
        }
    
        System.out.println(maxCount);
    }

}
