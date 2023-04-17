package less_02_16_04_23_hw.less_02_hw_task_02;

import java.io.BufferedReader;

/*
 * Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода в консоль:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class task_02_main {
    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        getCharFromFile(fileName); // вар.1
        System.out.println();
        getLineFromFile(fileName); // вар.2
    }


    private static void getCharFromFile (String fileName) {
        File file = new File("data.txt");
        try{
            FileReader fr = new FileReader(file);
            //rs = rs.replaceAll("&quote","");
            char [] ch = new char [(int) file.length()];
            StringBuilder resStr = new StringBuilder();
            fr.read(ch);
            for (char c : ch){
                if ((int)c == 0){ // "защита" от пустой строки
                    break;
                }
                if (c != '"'){
                    resStr.append(c);
                }
            }
            fr.close();

            String[] splites = resStr.toString().split("\n");
            // splites[0] - первая строка
            // splites[1] - вторая строка и т.п.
            for (String i : splites){
                String [] rs = i.split("[:,]"); 
                // rs[0] - "фамилия", rs[1] - значение
                // rs[2] - "оценка", rs[3]- значение
                // rs[4] - "предмет", rs[5] - значение
            System.out.printf("Студент %s получил %s по предмету %s\n", rs[1], rs[3], rs[5]);
            }
        }
        catch(Exception e){
            System.out.println("где-то что-то не так.....");
        }
    }

    
    private static void getLineFromFile(String fileName) {
        File file = new File(fileName);
        try{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null){
            line = line.replaceAll("\"",""); 
            String [] rs = line.split("[:,;]");    

            System.out.printf("Студент %s получил %s по предмету %s\n", rs[1], rs[3], rs[5]);
        }
        br.close();    
        }   
        catch(Exception e){
            System.out.println("где-то что-то не так.....");
        }
    }
}
