package less_02_16_04_23_hw.less_02_hw_task_01_bubble_sort;
/*
 * Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации запишите в лог-файл.
 */


import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task_01_main {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(task_01_main.class.getName());
        FileHandler fh = new FileHandler("logging_task_01.txt",false);

        Random rand = new Random();
        int minPoint = 1;
        int maxPoint = 100;
        int len = 10;
        int [] arr = new int [len];
        StringBuilder origArr = new StringBuilder();
        StringBuilder sortgArr = new StringBuilder();
        String tempOrigArrStr = "";

        try{
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);

            // форимрование исходного массива
            for (int i = 0; i < len; i++) {
                arr [i] = rand.nextInt(minPoint,maxPoint);
                origArr.append(arr [i] + " ");            
            }           
            String resOrigArr = String.format("Сформирован массив [размер = %d]:\n%s", len, origArr.toString());
            System.out.println(resOrigArr);           
            logger.setUseParentHandlers(false);
            logger.info(resOrigArr);
            
            // сортировка
            int step = 1; // счетчик шагов сортировки
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len - i - 1; j++) {
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j+1];                    
                        arr[j+1] = arr[j];
                        arr[j] = temp;
                        tempOrigArrStr = Arrays.toString(arr);
                        String res = String.format("шаг %d: %s", step, tempOrigArrStr);
                        System.out.println(res); 
                        
                        logger.setUseParentHandlers(false);
                        logger.log(Level.WARNING, res);
                        
                        step++;
                    }
                } 
            } 

            // отсортированный массив
            for (int k : arr) {
                sortgArr.append(k + " ");
            }
            String resSort = String.format("Отсортированный массив:\n%s",sortgArr.toString()); 
            System.out.println(resSort);
            logger.setUseParentHandlers(false);
            logger.info(resSort);
        }
        catch (Exception e){
            System.out.println("Что-то пошло не по плану.....");
        }
    }
}

