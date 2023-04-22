package less_03_22_04_23_hw;
// (Дополнительно) Реализовать алгоритм сортировки слиянием

import java.util.ArrayList;
import java.util.Random;
public class less_03_hw_task_01 {
    public static void main(String[] args) {
        int lenArr = 11;
        ArrayList<Integer> myArr = new ArrayList<Integer>();

        Random rand = new Random();
        int minPoint = 0;
        int maxPoint = 100;
        for (int i = 0; i < lenArr; i++) {
            myArr.add(rand.nextInt(minPoint,maxPoint));
        }
        System.out.println("original arr: " + myArr);
        System.out.println("sorted   arr: " + divideArr(myArr));
    }


    private static ArrayList<Integer> divideArr(ArrayList<Integer> arr) {
        if (arr.size() < 2){
            return arr;
        }
        int mid = arr.size() / 2;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i< mid; i++){
            left.add(arr.get(i));
        }
        for (int i = mid; i< arr.size(); i++){
                right.add(arr.get(i));
        }
        
        left = divideArr(left);
        right = divideArr(right);

        return mergeArrs(left,right);
    }

    
    private static ArrayList<Integer> mergeArrs(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        
        ArrayList<Integer> resArr = new ArrayList<Integer> ();
        int len = arr1.size() + arr2.size();
        int pointer1 = 0;
        int pointer2 = 0;

        for (int i = 0; i < len; i++) {
            if (pointer1 < arr1.size() && pointer2 < arr2.size()){
                if (arr1.get(pointer1) < arr2.get(pointer2)){
                    resArr.add(arr1.get(pointer1));
                    pointer1++;
                }
                else {
                    resArr.add(arr2.get(pointer2));
                    pointer2++;
                }
            }
            else if (pointer1 < arr1.size()){
                resArr.add(arr1.get(pointer1));
                pointer1++;
            }
            else {
                resArr.add(arr2.get(pointer2));
                pointer2++;
            }
        }
        return resArr;
    }
}
