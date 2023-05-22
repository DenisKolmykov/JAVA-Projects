package less_06_21_05_23_Class_Set;
/*
Урок 6. Хранение и обработка данных ч3: множество коллекций Set
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
NoteBook notebook1 = new NoteBook
NoteBook notebook2 = new NoteBook
NoteBook notebook3 = new NoteBook
NoteBook notebook4 = new NoteBook
NoteBook notebook5 = new NoteBook

Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет

Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

Класс сделать в отдельном файле

приветствие
Выбор параметра
выбор конкретнее
вывод подходящих
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class less_06_main {

//-------метод для назначения цены за ноутбуки---------
    public static void settingPrice(Set<Laptop> laptops) { //метод для назначения цены за ноутбуки
        Double basePrice = 500.0;
        Double bonusRam = null;
        Double bonusSsd = null;
        for (Laptop i : laptops) { 
            switch (i.getRam()){
                case (4):
                    bonusRam = 100.0;
                    break;
                case (8):
                    bonusRam = 150.0;
                    break;
                case (16):
                    bonusRam = 200.0;
                    break;
                case (32):
                    bonusRam = 250.0;
                    break;
            }
            switch (i.getSsd()){
                case (128):
                    bonusSsd = 130.0;
                    break;
                case (256):
                    bonusSsd = 270.0;
                    break;
                case (512):
                    bonusSsd = 350.0;
                    break;
            }
            i.setPrice(basePrice + bonusRam + bonusSsd);
        }
        System.out.println("! На все ноутбуки установлены новые цены в зависимости от RAM и SSD !\n");
    }

//-------метод  вывод на печать РЕКЛАМЫ ноутбуков---------
    public static void printAll(Set<Laptop> laptops){ // вывод на печать всей базы ноутбуков
        System.out.print("\033\143"); // очистка консоли

        //System.out.println (laptops); //"не крависивый" вывод в консоль
        System.out.println("-----Реклама НОУТБУКОВ-------");
        int j = 1;
        for (Laptop i : laptops) {
            System.out.print (j+". " + i); // "красивый вывод" в консоль
            j++;
        }
        System.out.println("---^--Реклама НОУТБУКОВ--^---");
        System.out.println();
    }

//-------ГЛАВНОЕ МЕНЮ---------
    public static void mainMenu(Scanner iScanner, Set<Laptop> laptops){
        System.out.print("\033\143"); // очистка консоли
        boolean stop = true;
        while (stop) {
            System.out.println("---ГЛАВНОЕ МЕНЮ---");
            System.out.printf("Введите:\n1.Вывести всю базу ноутбуков в консоль\n2.Установить(изменить) цену на все ноутбуки (автоматически)\n3.Перейти к фильтру\n4.Удалить позицию из базы\n0.Для выхода\n--> ");
            Integer operation = iScanner.nextInt();
            switch (operation){
                case(0):
                    stop = false;
                    break;
                case(1):
                    printAll(laptops);
                    break;
                case(2):
                    settingPrice (laptops); // назначаем новые цены
                    break;
                case(3):
                    filterMenu(iScanner, laptops);
                    break;
                case(4):
                    laptops = deletePosition(iScanner, laptops);
                    break;
            }
        }
    }
//-------Удаление позиции---------
    public static Set <Laptop> deletePosition(Scanner iScanner, Set<Laptop> laptops){
        System.out.print("\033\143"); // очистка консоли
        System.out.println("---УДАЛЕНИЕ ПОЗИЦИИ---");
        printFilteredResult(laptops);
        System.out.print("Выбрать позицию для УДАЛЕНИЯ из базы ---> ");
        Integer operation = iScanner.nextInt();
        System.out.print("\033\143"); // очистка консоли
        int op = 1;
        for (Laptop del : laptops) {
            if (op == operation){
                System.out.println("УДАЛЕНА позиция: " + op + ". ");
                System.out.print("---> ");
                del.printing();
                laptops.remove(del);
                break;
            }
            op++;
        }
        System.out.println("база ноутбуков ОБНОВЛЕНА:");
        printFilteredResult(laptops);
        return laptops;
    }

//-------МЕНЮ ФИЛЬТРОВ---------
    public static void filterMenu (Scanner iScanner, Set<Laptop> laptops){
        System.out.print("\033\143"); // очистка консоли
        
        Set <Laptop> filteredResult = new HashSet<>(laptops);
        
        boolean stop = true;
        while (stop) {
            System.out.println("---ФИЛЬТР---");
            System.out.printf("Введите критерий фильтрации:\n1.ОЗУ\n2.Размер SSD\n3.Операционная система\n4.Цвет\n5.Печать результатов\n0.Для выхода в ГЛАВНОЕ МЕНЮ\n--> ");
            Integer operation = iScanner.nextInt();
            switch (operation){
                case (0):
                    stop = false;
                    break;
                case (1):
                    filteredResult = sortingRam(iScanner,filteredResult);
                    break;
                case (2):
                    filteredResult = sortingSsd(iScanner,filteredResult);
                    break;
                case (3):
                    filteredResult = sortingOs(iScanner,filteredResult);
                    break;
                case (4):
                    filteredResult = sortingColor(iScanner,filteredResult);
                    break;
                case (5):
                    System.out.print("\033\143"); // очистка консоли
                    printFilteredResult(filteredResult);
                    break;
            }
        }
    }

//-------МЕНЮ фильтра по RAM---------
    public static Set <Laptop> sortingRam (Scanner iScanner, Set<Laptop> laptops){
        System.out.print("\033\143"); // очистка консоли
        
        Set <Laptop> filteredResult = new HashSet<>();

        System.out.println("---фильтр по RAM---");
        System.out.printf("Выберете размер RAM для фильтрации:\n1.<=8Gb\n2.от 8 до 16 Gb\n3.от 16 до 32 Gb\n4.>=32Gb\n--> ");
        Integer operation = iScanner.nextInt();
        switch (operation){
            case (1):
                for (Laptop l : laptops) {
                    if (l.getRam() <= 8){
                        filteredResult.add(l);
                    } 
                }
                break;
                
            case (2):
                for (Laptop l : laptops) {
                    if (l.getRam() >= 8 && l.getRam() <= 16){
                        filteredResult.add(l);
                    }
                } 
                break;
                
            case (3):
                for (Laptop l : filteredResult) {
                    if (l.getRam() >= 16 && l.getRam() <= 32){
                        filteredResult.add(l);
                    }
                } 
                break;
                
            case (4):
                for (Laptop l : filteredResult) {
                    if (l.getRam() >= 32){
                        filteredResult.add(l);
                    }
                } 
                break;
        }
        if (filteredResult.size() == 0){
            System.out.println("!По заданным параметрам позиций не найдено!");
            filteredResult = laptops;
        }
        else {
            printFilteredResult(filteredResult);
        }
        return filteredResult;
    }

//-------МЕНЮ фильтра по SSD---------
    public static Set <Laptop> sortingSsd(Scanner iScanner, Set<Laptop> laptops){
        System.out.print("\033\143"); // очистка консоли
        
        Set <Laptop> filteredResult = new HashSet<>();
        
        System.out.println("---фильтр по SSD---");
        System.out.printf("Выберете размер SSD для фильтрации:\n1.<=128Gb\n2.от 128 до 256 Gb\n3.от 256 до 512 Gb\n4.>=512Gb\n--> ");
        Integer operation = iScanner.nextInt();
        switch (operation){
            case (1):
                for (Laptop l : laptops) {
                    if (l.getSsd() <= 128){
                    filteredResult.add(l);
                    } 
                }
                break;
                
            case (2):
                for (Laptop l : laptops) {
                    if (l.getSsd() >= 128 && l.getSsd() <= 256){
                        filteredResult.add(l);
                    }
                } 
                break;
                
            case (3):
                for (Laptop l : laptops) {
                    if (l.getSsd() >= 256 && l.getSsd() <= 512){
                        filteredResult.add(l);
                    }
                } 
                break;
                
            case (4):
                for (Laptop l : laptops) {
                    if (l.getSsd() >= 512){
                        filteredResult.add(l);
                    }
                } 
                break;
        }
        if (filteredResult.size() == 0){
            System.out.println("!По заданным параметрам позиций не найдено!");
            filteredResult = laptops;
        }
        else {
            printFilteredResult(filteredResult);
        }
        return  filteredResult;
    }

//-------МЕНЮ фильтра по OS---------
    public static Set <Laptop> sortingOs(Scanner iScanner, Set<Laptop> laptops){
        System.out.print("\033\143"); // очистка консоли

        Set <Laptop> filteredResult = new HashSet<>();
        
        System.out.println("---фильтр по OS---");
        System.out.printf("Выберете операционную систему (OS) для фильтрации:\n1.Windows\n2.iOs\n3.HarmonyOs\n--> ");
        Integer operation = iScanner.nextInt();
        switch (operation){
            case (1):
                for (Laptop l : laptops) {
                    if (l.getOs().equals("Windows")){
                    filteredResult.add(l);
                    } 
                }
                break;
                
            case (2):
                for (Laptop l : laptops) {
                    if (l.getOs().equals("iOs")){
                        filteredResult.add(l);
                    }
                } 
                break;
                
            case (3):
                for (Laptop l : laptops) {
                    if (l.getOs().equals("HarmonyOS")){
                        filteredResult.add(l);
                    }
                } 
                break;
        }
        if (filteredResult.size() == 0){
            System.out.println("!По заданным параметрам позиций не найдено!");
            filteredResult = laptops;
        }
        else {
            printFilteredResult(filteredResult);
        }
        return  filteredResult;
       
    }

//-------МЕНЮ фильтра по ЦВЕТУ---------
    public static Set <Laptop> sortingColor(Scanner iScanner, Set<Laptop> laptops){
        System.out.print("\033\143"); // очистка консоли

        Set <Laptop> filteredResult = new HashSet<>();
        
        System.out.println("---фильтр по ЦВЕТУ---");
        System.out.printf("Выберете ЦВЕТ для фильтрации:\n1.Черный\n2.Серебристый\n3.Графит\n4.Красный\n--> ");
        Integer operation = iScanner.nextInt();
        switch (operation){
            case (1):
                for (Laptop l : laptops) {
                    if (l.getColor().equals("Черный")){
                    filteredResult.add(l);
                    } 
                }
                break;
                
            case (2):
                for (Laptop l : laptops) {
                    if (l.getColor().equals("Серебристый")){
                        filteredResult.add(l);
                    }
                } 
                break;
                
            case (3):
                for (Laptop l : laptops) {
                    if (l.getColor().equals("Графит")){
                        filteredResult.add(l);
                    }
                } 
                break;
                
            case (4):
                for (Laptop l : laptops) {
                    if (l.getColor().equals("Красный")){
                        filteredResult.add(l);
                    }
                } 
                break;
        }
        if (filteredResult.size() == 0){
            System.out.println("!По заданным параметрам позиций не найдено!");
            filteredResult = laptops;
        }
        else {
            printFilteredResult(filteredResult);
        }
        return  filteredResult;

    }

//-------печать БАЗЫ НОУТБУКОВ---------
    public static void printFilteredResult(Set<Laptop> filteredResult){
        int j = 1;
        System.out.println("----результаты фильтрации------");
        for (Laptop f : filteredResult) {
            System.out.print(j + ". ");
            f.printing();
            j++;
        }
        System.out.println("--^--результаты фильтрации--^---\n");
    }

//-------ОСНОВНОЙ КОД---------
    public static void main(String[] args){
        Laptop laptop1 = new Laptop("Xiaomi", 8, 256, "Windows", "Красный", "Intel");
        laptop1.price = 900.0;
        Laptop laptop2 = new Laptop("Sumsung", 16, 512, "Windows", "Серебристый", "AMD");
        laptop2.price = 1100.0;
        Laptop laptop3 = new Laptop("Apple", 32, 256, "iOs", "Графит", "М2");
        laptop3.price = 1050.0;
        Laptop laptop4 = new Laptop("Lenovo", 8, 128, "Windows", "Серебристый", "Intel");
        laptop4.price = 850.0;
        Laptop laptop5 = new Laptop("Huawei", 8, 256, "HarmonyOS", "Графит", "AMD");
        laptop5.price = 990.0;
        Laptop laptop6 = new Laptop("Xiaomi", 16, 512, "Windows", "Серебристый", "AMD");    
        laptop6.price = 1150.0;
        Laptop laptop7 = new Laptop("Sumsung", 8, 256, "Windows", "Красный", "Intel");
        laptop7.price = 900.0;
        Laptop laptop8 = new Laptop("Apple", 8, 128, "iOs", "Серебристый", "М1");
        laptop8.price = 820.0;
        Laptop laptop9 = new Laptop("Lenovo", 4, 128, "Windows", "Черный", "Intel");
        laptop9.price = 999.0;
        Laptop laptop10 = new Laptop("Huawei", 16, 512, "HarmonyOS", "Черный", "AMD");
        laptop10.price = 1100.0;

        Set <Laptop> laptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, 
        laptop6, laptop7, laptop8, laptop9, laptop10));
        
        Scanner iScanner = new Scanner (System.in);
        mainMenu (iScanner, laptops);
        System.out.println("\n!Сеанс завершен!");
        
        iScanner.close();
    } 
}
       

