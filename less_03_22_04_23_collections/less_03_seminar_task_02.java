package less_03_22_04_23_collections;

// посчитать и вывести количество каждого вхождения элементов

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class less_03_seminar_task_02 {
    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<>
        (Arrays.asList("Земля", "Венера", "Юпитер", "Земля", "Сатурн", "Марс", "Плутон", "Земля", "Юпитер"));
        int i = 0;
        while (i < planets.size()){
        //for(int i = 0; i < planets.size(); i++){
            int temp = Collections.frequency(planets, planets.get(i));
            System.out.println(planets.get(i) + " - " + temp);
            removeElem(planets, planets.get(i));
        }
    }


    private static ArrayList<String> removeElem(ArrayList<String> arr, String elemToRemove) {
        for (int i = arr.size()-1; i >= 0; i--){
            if (arr.get(i).equals(elemToRemove)){
                arr.remove(i);
            }
        }
    return arr;
    }
}
