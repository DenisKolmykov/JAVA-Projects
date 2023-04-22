package less_03_22_04_23_collections;

// посчитать и вывести количество каждого вхождения элементов

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.text.html.HTMLDocument.Iterator;

public class less_03_seminar_task_02 {
    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<>
        (Arrays.asList("Земля", "Венера", "Юпитер", "Земля", "Сатурн", "Марс", "Плутон", "Земля", "Юпитер"));
        for(int i = planets.size()-1; i >= 0; i--){
            int temp = Collections.frequency(planets, planets.get(i));
            System.out.println(planets.get(i) + "-" + temp);
            planets.removeAll(i);
        }
    }
}
