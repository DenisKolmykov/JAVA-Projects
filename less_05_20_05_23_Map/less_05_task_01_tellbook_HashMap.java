package less_05_20_05_23_Map;
/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь 
несколько телефонов.
Добавить функции:
1) Добавление номера
2) Вывод всего
Пример:
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 1242353
К: Введите 1) Добавление номера
2) Вывод всего
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 547568
К: Введите 1) Добавление номера
2) Вывод всего
Я: 2
Иванов: 1242353, 547568
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class less_05_task_01_tellbook_HashMap {
    public static void main(String[] args){
    Map<String, ArrayList<String>> tBook = new HashMap<>();
    boolean stop = false;
    Scanner iScanner = new Scanner (System.in);
        while (!stop){
            ArrayList<String> tNumber = new ArrayList<>();
            System.out.printf("Введите:\n1-Добавление номера\n2-Вывод всего\nstop-для выхода: ");
            String operation = iScanner.nextLine();
            System.out.println();
            if (operation.equals("stop")){
                System.out.println("Ввод завершен");
                stop = true;
            }
            else if (operation.equals("1")){
                System.out.printf("Введите фамилию: ");
                String myKey = iScanner.nextLine();
                System.out.printf("Введите номер телефона: ");
                String myNumber = iScanner.nextLine();
                boolean tNumTrue = true;
                for (String j :  tBook.keySet()) {
                    ArrayList<String> tNumberTemp = tBook.get(j);
                    if (tNumberTemp.contains(myNumber)){
                        System.out.println("!Запись не добавлена!\nТакой номер уже есть в телефонной книге\nПовторите ввод");
                        tNumTrue = false;
                        break;
                    }
                }
                if (tNumTrue){
                    if (tBook.containsKey(myKey)){
                        tNumber = tBook.get(myKey);
                    }
                    tNumber.add(myNumber);
                    tBook.put(myKey, tNumber);
                    System.out.println("!Запись успешно добавлена!\n");
                }  
            }
            else if (operation.equals("2")){
                for (String i : tBook.keySet()) {
                    tNumber = tBook.get(i);
                    System.out.print(i + ": " );
                    String result = String.join(", ", tNumber);
                    System.out.print (result);
                    System.out.println();
                }
            }
            System.out.println(); 
        }
        iScanner.close();
    }
}
