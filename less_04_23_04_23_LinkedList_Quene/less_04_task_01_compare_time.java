package less_04_23_04_23_LinkedList_Quene;
// Замерьте время, за которое в LinkedList добавятся 100000 элементов. 
// Сравните с добавлением через ArrayList.

import java.util.ArrayList;
import java.util.LinkedList;

public class less_04_task_01_compare_time {
    public static void main(String[] args) {
        long startTime1 = System.currentTimeMillis();
        int length = 500_000;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i <= length; i++){
            myList.add(0,i);
        }
        // System.out.println(myList);
        long sratrtime2 = System.currentTimeMillis() - startTime1;
        

        long startTime1_1 = System.currentTimeMillis();
        LinkedList<Integer> myLList = new LinkedList<>();
        for (int i = 0; i <= length; i++){
            myLList.add(0,i);
        }
        // System.out.println(myList);
        long sratrtime2_1 = System.currentTimeMillis() - startTime1_1;
        
        System.out.println("Время выполнения (ArrayList): " + sratrtime2 + " мс");
        System.out.println("Время выполнения (LinkedList): " + sratrtime2_1 + " мс");
    }
}
