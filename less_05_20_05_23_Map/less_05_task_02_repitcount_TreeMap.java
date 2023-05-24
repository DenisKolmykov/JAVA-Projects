package less_05_20_05_23_Map;
/*
 Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов

Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности Имени.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class less_05_task_02_repitcount_TreeMap {
    public static void main(String[] args) {
        String [] employees = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", 
        "Анна Мусина", "Анна Мусина", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", 
        "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", 
        "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        
        // формируем коллекцию: ключ - имя / значение - кол-во повторов
        TreeMap<String, Integer> nameRepeatCount = new TreeMap<>();
        for (String n : employees) {
            String[] names = n.split(" ");
            String name = names[0];
            if (nameRepeatCount.containsKey(name)){
                nameRepeatCount.put(name,nameRepeatCount.get(name)+1);
            }
            else {
                nameRepeatCount.put(name,1);
            }
        }
        //System.out.println(nameRepeatCount); // для проверки

        // переписываем коллекцию = ключ-повторение/ значение-список имен (с сортировкой по убыванию Collections.reverseOrder())
        TreeMap<Integer,ArrayList<String>> sortedNames = new TreeMap<>(Collections.reverseOrder());
        /* 
        for (String n : nameRepeatCount.keySet()) { //пробегаем по ключам
            ArrayList<String> namesList = new ArrayList <>();
            if (sortedNames.containsKey(nameRepeatCount.get(n))){
                namesList = sortedNames.get(nameRepeatCount.get(n));
            }
            namesList.add(n);
            sortedNames.put(nameRepeatCount.get(n), namesList);
        }
        */
        for (var n : nameRepeatCount.entrySet()) { // пробегаем по парам
            ArrayList<String> namesList = new ArrayList <>();
            if (sortedNames.containsKey(n.getValue())){
                namesList = sortedNames.get(n.getValue());
            }
            namesList.add(n.getKey());
            sortedNames.put(n.getValue(), namesList);
        }

        // вывод результата
        //System.out.println(sortedNames); // для проверки
        for (Integer i : sortedNames.keySet()) {
            String result = String.join(", ", sortedNames.get(i));
            System.out.print(result + ": " + i);
            System.out.println();
        }      
    }
}
