package less_03_22_04_23_collections;
// отсортировать массив


import java.util.ArrayList;
import java.util.Random;

public class less_03_seminar_task_01_arrList {
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
        myArr.sort(null);
        System.out.println("sorted   arr: " + myArr);
    }
}
