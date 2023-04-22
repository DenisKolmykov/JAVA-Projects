package less_03_22_04_23_hw;
// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class less_03_hw_task_03 {
    public static void main(String[] args) {
        int lenArr = 3;
        ArrayList<Integer> myArr = new ArrayList<Integer>();

        Random rand = new Random();
        int minPoint = 0;
        int maxPoint = 100;
        for (int i = 0; i < lenArr; i++) {
            myArr.add(rand.nextInt(minPoint,maxPoint));
        }
        System.out.println("original arr: " + myArr);
        // int maxElem = Collections.max(myArr);
        // int minElem = Collections.min(myArr);
        myArr.sort(null);
        int maxElem = myArr.get(myArr.size()-1);
        int minElem = myArr.get(0);
        
        int summa = 0;
        for (int elem : myArr){
            summa += elem;
        }
        float averageElem = (float)summa / myArr.size();

        System.out.println("max element = " + maxElem);
        System.out.println("min element = " + minElem);
        System.out.printf("average of Arr = %.2f\n", averageElem);
    }
}
