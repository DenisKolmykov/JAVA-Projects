package less_01_15_04_23_hw;
/*
 * * Дополнительно: +Задано уравнение вида q + w = e, q, w, e >= 0. 
 * Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
 * Требуется восстановить выражение до верного равенства. 
 * Предложить хотя бы одно решение или сообщить, что его нет. 
 * Под знаками вопросов - одна и та же цифра Ввод: 2? + ?5 = 69 Вывод: 24 + 45 = 69
 */

import java.util.Scanner;

public class less_01_hw_task_04 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner (System.in);
        
        System.out.printf("Введите выражение: ");  // работает на числах любой разрядности 
        String sample = iScanner.nextLine();              // (например,?1 + 2?? = 264 --> 31 + 233 = 264)
        iScanner.close();                                 // (напрмер, 1?2 + ?2? = 455 --> 132 + 323 = 455)

        String [] parts = sample.split(" ");  // разделяем выражение на части (числа, знаки, результат)
                                                    // parts[0] - первое число, parts[2] - второе число
        int numRes = Integer.parseInt(parts[4]);    // parts[4] - результат

        boolean flag = true; 

        for (int i = 0 ; i <= 9; i++) {             //  перебираем цифры для подставноки вместо "?"

            int num1 = strToNum(parts[0], i);       // формируем первое число (формата int) из parts[0]
            int num2 = strToNum(parts[2], i);       // формируем второе число (формата int) из parts[2]
            
            if (num1 + num2 == numRes) {
                System.out.printf("%d + %d = %d\n", num1, num2, numRes);
                flag = false;   
                break;          //  если нашли цифру вместо "?" - прекращаем цикл-подбор
            }
        }
        if (flag) {             // если после перебора всец цифр в пред/цикле - выражение не найдено, 
            System.out.println("!!! Такое выражение не возмоно");
        }

    }

    // метод для формирования числа int из String
    // с заменой "?" на цифру "i"
    private static int strToNum(String numParts, int i) {   
        int lenNum = numParts.length();
        String numStr[] = numParts.split("");
        StringBuilder numS = new StringBuilder();
        int num = 0;
        for (int j = 0; j < lenNum; j++) {
            if (numStr[j].equals("?")) {
                numS.append(i);
            }
            else {
                numS.append(numStr[j]);
            }
            num = Integer.parseInt(numS.toString());
        }
        return num;
    }
}
