package less_04_23_04_23_LinkedList_Quene;
// Реализовать консольное приложение, которое:
// 1. Принимает отпользователя строку вида text 
// 2. Необхоимо сохранить text в связный список
// 3. и если введено print~num, вывести строку из позиции num в связном списке и удалить ее
// ввод за циклен, пока не введено stop

import java.util.LinkedList;
import java.util.Scanner;

public class less_04_task_02_LL_add_remove {
    public static void main(String[] args) {
        LinkedList <String> myText = new LinkedList<>();
        boolean stop = true;
        Scanner iScanner = new Scanner (System.in);
        while (stop){
            System.out.printf("Введите строку или print~num или stop: ");
            String operation = iScanner.nextLine();
            if (operation.equals("stop")){
                System.out.println("Ввод завершен");
                stop = false;
            }
            else if (operation.contains("print~")){
                Integer index = Integer.parseInt(operation.substring(6, operation.length()));
                if (index > 0 && index <= myText.size()){
                    System.out.println("Будет удален элемент с позиции " + index + ": " + myText.get(index - 1));
                    myText.remove(index - 1);
                }
                else{
                    System.out.println("В списке отсутстует элемент на позиции " + index);
                }
            }
            else {
                myText.add(operation);
            }
            System.out.println("Список после действий пользователя: " + myText);
        }
        iScanner.close();
    }
}
