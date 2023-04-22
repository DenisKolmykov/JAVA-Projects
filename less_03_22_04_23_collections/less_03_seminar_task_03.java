package less_03_22_04_23_collections;
// создать arrayList в котором элементы и строковые и числа, удалить из списка числа

import java.util.ArrayList;
import java.util.Arrays;
public class less_03_seminar_task_03 {
    public static void main(String[] args) {
        ArrayList myList = new ArrayList <>
        (Arrays.asList("Вася", 6, "Петя", 11, "Меркурий", 12, 18, "Хлеб", "Батон", 22, 99));
        for (int i = myList.size()-1; i >= 0; i--){
            if (myList.get(i) instanceof Integer){
                myList.remove(i);
            }
        }
        System.out.println(myList);
    }
}
