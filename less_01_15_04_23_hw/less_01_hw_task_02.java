package less_01_15_04_23_hw;
//Вывести все простые числа от 1 до 1000

import java.util.ArrayList;

public class less_01_hw_task_02 {
    public static void main(String[] args) {
        ArrayList<Integer> simpleNums = new ArrayList<>();
        simpleNums.add(3); // сразу запишем в список "первое" (помимо 1 и 2) простое число
        for (int i = 5; i <= 1000; i = i + 2) { // четные числа сразу пропускаем
            boolean flag = true;
            for (int j : simpleNums) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                simpleNums.add(i);
            }
        }
        simpleNums.add(0, 1); // добавляем 1 и 2 после формирования списка 
        simpleNums.add(1, 2); // (чтобы в процессе формирования не делить на них)

        System.out.println(simpleNums);
    }
    
}
