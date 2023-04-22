package less_03_22_04_23_hw;
// Пусть дан произвольный список целых чисел, удалить из него чётные числа

import java.util.ArrayList;
import java.util.Random;

public class less_03_hw_task_02 {
    public static void main(String[] args) {
        int lenArr = 10;
        ArrayList<Integer> myArr = new ArrayList<Integer>();

        Random rand = new Random();
        int minPoint = 0;
        int maxPoint = 10;
        for (int i = 0; i < lenArr; i++) {
            myArr.add(rand.nextInt(minPoint,maxPoint));
        }
        System.out.println("original arr: " + myArr);

        for (int j = myArr.size()-1; j >= 0; j--){
            if (myArr.get(j) % 2 == 0){
                myArr.remove(j);
            }
        }
        System.out.println("arr without even nums: " + myArr);
        
    }
}
