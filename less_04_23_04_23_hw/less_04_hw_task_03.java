package less_04_23_04_23_hw;
/*
 * 3) В калькулятор добавьте возможность отменить последнюю операцию.
Пример

1
+
2
ответ:
3

+
4
ответ:
7
+
2

ответ:

9
1
Ответ 8
Отмена -> 9
Отмена -> 7
Отмена -> 3
+
2
Ответ 5
 */


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class less_04_hw_task_03 {
    public static void main(String[] args) {
        String mathOper = "+-/*^%"; // для проверки корректности ввода мат.операции
        Deque <Double> myQueue = new LinkedList<>(); // для хранения результатов
        Double [] twoNums = new Double [2]; // для хранения чисел для мат.операций
        boolean stop = false; // выход из калькулятора можно ввести на любом этапе
        int count = 1;  // счетчик операций
        int numsCount = 0; // счетчик чисел для мат.операций
        Double result; // результат мат.операции
        String operation = ""; // математическая операция
        String cancel = "q"; // символ для отмены операции

        Scanner iScanner = new Scanner (System.in);
        while (!stop){
            String command = inputOperation(iScanner);
            if (command.equals("stop")){
                System.out.println("Ввод завершен");
                stop = true;
            }
            else if (command.equals(cancel)){        // отмена последней операции (можно ввести на люблм этапе)
                //System.out.println(myQuene);
                if (!myQueue.isEmpty()){
                    Double del = myQueue.pop();
                    System.out.printf("последняя операция c результатом %.2f отменена.\n", del);
                    twoNums[0] = myQueue.peek();
                    twoNums[1] = null;
                }
                if (myQueue.isEmpty()) {
                    System.out.println("Вы отменили все операции.\nВведите 'stop'-для выхода или число для операции: ");
                    count = 1;
                    numsCount = 0;
                    operation = "";
                }
                else {
                    System.out.print("предыдущий результат: ");
                    System.out.printf("%.2f\n",twoNums[0]);
                }

            }

            else {
                if (count % 2 != 0) { // на четном count - надо вводить мат.операцию , а на нечетном - число
                    if (isNumeric (command)){ 
                        twoNums[numsCount] = Double.parseDouble(command);;
                        numsCount++;
                        count++;
                    }
                    else {
                        System.out.println("! Необходимо ввести число. Повторите ввод");
                    }
                }
                else {
                    if (!mathOper.contains(command)) {
                        System.out.println("! Необходимо ввести математическую операцию. Повторите ввод");
                    }
                    else {
                        operation = command;
                        count++;
                    }       
                }
            }
            if (numsCount == 2){    // если есть два числа для мат.операций (если нет - уходим на цикл ввода: чтоб можно было stop на любом этапе)
                Double num1 = twoNums[0];
                Double num2 = twoNums[1];
                result = getRes (num1, num2, operation);

                if (result != null) {
                    System.out.printf("--> %.2f %s %.2f = %.2f\n", num1, operation, num2, result);
                    twoNums[0] = result;
                    myQueue.push(result);
                }
                else {
                    operation = "";
                    twoNums[0] = myQueue.peek();
                    twoNums[1] = null;
                    System.out.print("предыдущий результат: ");
                    System.out.println(twoNums[0]);
                }
                numsCount = 1;
            }
        }
        iScanner.close();
    }


    private static String inputOperation(Scanner iScanner) {
        System.out.print("--> ");
        String command = iScanner.nextLine();
        return command;
    }


    private static boolean isNumeric(String str) { // проверка на корректность ввода - числа
        try {
          Double.parseDouble(str);
          return true;
        } 
        catch(NumberFormatException e){
          return false;
        }
    }


    private static Double getRes(Double num1, Double num2, String operation) {
        Double res = null;
        switch (operation) {
            case "+":
                res = num1 + num2;            
                break;
                    
            case "-":
                res = num1 - num2;            
                break;
                            
            case "*":
                res = num1 * num2;            
                break;
                            
            case "/":
                if (num2 != 0){
                    res = num1 / num2;
                }                 
                else{
                    System.out.println("! Вы пытаетесь делить на ноль.\n! Операция отменена!");
                }          
                break;
                            
            case "^":
                res = Math.pow(num1, num2);            
                break;
                        
            case "%":
                res = num1 % num2;            
                break;    
        }
        return res;
    }
}
