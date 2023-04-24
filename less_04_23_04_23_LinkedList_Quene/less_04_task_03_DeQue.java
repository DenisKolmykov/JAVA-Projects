package less_04_23_04_23_LinkedList_Quene;
/*
Реализовать консольное приложение, которое:

1. Принимает от пользователя и “запоминает” строки.
2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке,
 а первая - последней.

 реализовать через Quene

asd
qwe
zxc
print
zxc
qwe
asd
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class less_04_task_03_DeQue {
    public static void main(String[] args) {
        Deque <String> myQuene = new LinkedList<>();
        boolean stop = false;
        Scanner iScanner = new Scanner (System.in);
        while (!stop){
            System.out.printf("Введите строку или print или stop: ");
            String operation = iScanner.nextLine();
            if (operation.equals("stop")){
                System.out.println("Ввод завершен");
                stop = true;
            }
            else if (operation.equals("print")){
                System.out.println(myQuene);        // если после print - добавляем к списку
                // while (!myQuene.isEmpty()){      // если после print - формируем новый список
                //     System.out.printf(myQuene.pop()+" ");
                // }
                // System.out.println();
            }
            else {
                myQuene.push(operation);;
            }
        }
        iScanner.close();
    }
}
