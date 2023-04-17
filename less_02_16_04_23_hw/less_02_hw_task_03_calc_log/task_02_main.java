package less_02_16_04_23_hw.less_02_hw_task_03_calc_log;
/*
 * дополнительно. К калькулятору из предыдущего дз добавить логирование.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class task_02_main {
    public static void main(String[] args) throws SecurityException, IOException {

        Scanner iScanner = new Scanner (System.in);

        System.out.print("Введите первое число (num1): ");
        String temp = iScanner.nextLine();
        float num1 = Float.parseFloat(temp);

        System.out.printf("Введите математическую операцию (+ - * /): ");
        String operation = iScanner.nextLine();

        System.out.printf("Введите второе число (num2): ");
        float num2 = iScanner.nextInt();
        iScanner.close();
        
        float res = 0;
        boolean flag = true;

        if (operation.equals("*")) {
            res = num1 * num2;
        }

        else if (operation.equals("+")) {
            res = num1 + num2;
        }

        else if (operation.equals("-")) {
            res = num1 - num2;
        }

        else if (operation.equals("/")) {
            if (num2 == 0) {
                System.out.println("Вы пытаетесь делить на ноль!!!");
                flag = false;
            }
            else {
                res = num1 / num2;
            }
        }
        else {
            flag = false;
        }
        
        //String fileName = "log_file_task_03.txt";
        //File logFile = new File(fileName);

        Logger logger = Logger.getLogger(task_02_main.class.getName());
        FileHandler fh = new FileHandler("logging_task_03.txt",true);


        String resultString="";
        try{
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);

            if (flag){
                resultString = String.format("%.2f %s %.2f = %.2f\n", num1, operation, num2,res);
                logger.setUseParentHandlers(false);
                logger.info(resultString);
            }
            else{
                resultString = String.format("Введены не корректные данные: %.2f %s %.2f\n",num1, operation, num2);
                //System.out.println(resultString);
                logger.setUseParentHandlers(false);
                logger.log(Level.WARNING, resultString);
            }
            
            System.out.println(resultString);

            //writer.write(resultString);
                
            //writer.close();
            System.out.println("Успешная запись в файл ");
        }
        catch (Exception e){
            System.out.println("Что-то пошло не по плану.....");
        }
        
    }
}

