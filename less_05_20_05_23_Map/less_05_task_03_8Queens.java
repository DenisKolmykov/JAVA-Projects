package less_05_20_05_23_Map;
/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. 
И вывести Доску. Пример вывода доски 8x8
0x000000
0000x000
00x00000
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class less_05_task_03_8Queens {
    
    // заполнение Мар (словарь позиций шахматной доски)
    public static HashMap<Integer,Integer> fillBoardMap(){
        HashMap <Integer,Integer> board = new HashMap <>(); // шахматная доска
        // формируем позиции на шахматной доске: ключ-координаты, значение-ферзь("0"-отсутствие;"-1"-битое поле; "9"-буфер доски)
        for (int i = 11; i <= 88; i++){
            if (i % 10 != 0 && i % 10 != 9){
                board.put(i, 0); 
            }
        }
        // заполняем "буферную зону" доски
        Integer [] pos = {0,1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,
                          19,29,39,49,59,69,79,89,91,92,93,94,95,96,97,98,99};
        for (Integer p: pos) {
            board.put(p,9);
        }
        return board;
    }

    
    // отображение шахматной доски
    public static void printBoard(HashMap<Integer,Integer> board){
        for (int i = 10; i <= 80; i = i + 10){
            for (int j= 1; j <=8; j++){
                int k = i + j;
                System.out.printf("%3d",board.get(k));
            }
            System.out.println();
        }
        System.out.println();
    }
    

    // формирование случайной (RANDOM) позиции ПЕРВОГО ферзя
    public static Integer randFirstPosition(){
        Random rd = new Random();
        // массив позиций шахмотной доски для случайной позиции ПЕРВОГО ферзя
        // Integer[] keys = {11, 12, 13, 14, 15, 16, 17, 18, 21, 22, 23, 24, 25, 26, 27, 28, 
                        //   31, 32, 33, 34, 35, 36, 37, 38, 41, 42, 43, 44, 45, 46, 47, 48, 
                        //   51, 52, 53, 54, 55, 56, 57, 58, 61, 62, 63, 64, 65, 66, 67, 68, 
                        //   71, 72, 73, 74, 75, 76, 77, 78, 81, 82, 83, 84, 85, 86, 87, 88}; 
        Integer[] keys = {14, 51, 37, 56, 86, 23, 13, 81};
        Integer position = keys[rd.nextInt(keys.length)]; // случайная позиция первого ферзя
        return position;
    }


    // формирование позиции ПЕРВОГО ферзя (ручной ввод от ПОЛЬЗОВАТЕЛЯ)
    public static Integer userFirstPosition(){
        ArrayList<String> letter = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","J","H"));
        
        Scanner iScanner = new Scanner (System.in);
        boolean flag = true;
        Integer collNum = 0;
        Integer rowNum = 0;
        while (flag){
            System.out.println("Введите координаты первого ферзя");
            System.out.printf("буква (A,B,C,D,E,F,J,H): ");
            String collLetter = iScanner.nextLine().toUpperCase();
            if (letter.contains(collLetter)){
                collNum = letter.indexOf(collLetter)+1;
                flag = false;
            }
        }
        while (!flag) {
            System.out.printf("номер линии (1,2,3,4,5,6,7,8): ");
            rowNum = iScanner.nextInt();
            if (rowNum >= 1 &&  rowNum <= 8){
                flag = true;
            }
        }
        iScanner.close();
        Integer position = Integer.parseInt(collNum.toString() + rowNum.toString());
    return position;
    }

    
    // заполнение битых позиций
    public static HashMap <Integer,Integer> fillBitPosition(HashMap<Integer,Integer> board, Integer position){
        // массив позиций, которые бъет ферзь (смещение относительно позиции ферзя)
        Integer [][] shift = {{-1,-2,-3,-4,-5,-6,-7},{1,2,3,4,5,6,7,8},
                              {-10,-20,-30,-40,-50,-60,-70},{10,20,30,40,50,60,70},
                              {-11,-22,-33,-44,-55,-66,-77},{11,22,33,44,55,66,77},
                              {-9,-18,-27,-36,-45,-54,-63},{9,18,27,36,45,54,63}};
        for (Integer a = 0; a < shift.length; a++){
            for (Integer i = 0; i < shift[a].length; i++){
                int k = position + shift[a][i];
                if (board.get(k) == 9){
                    break;
                }
                else {
                    board.put(k,-1);
                }
            }
        }
    return board; 
    }


    // свободные позиции - в отдельный Set
    public static HashSet<Integer> freePosition(HashMap<Integer,Integer> board){
        HashSet<Integer> freeBoard = new HashSet<>();
        for (Integer j = 0; j < board.size(); j++){ 
            if (board.get(j) == 0){
                freeBoard.add(j);
            }
        }
        return freeBoard;
    }


    // расстановка остальных ферзей
    public static Stack<Integer> Queens(HashMap<Integer,Integer> board, HashSet<Integer> freeBoard, Stack<Integer> positionsQueens){
        if (freeBoard.size() == 0){
            return positionsQueens;
        }

        Iterator<Integer> iterator = freeBoard.iterator();
        Integer pos = iterator.next();
    
        positionsQueens.push(pos);
        //System.out.println(pos);
        //System.out.println(positionsQueens);
        board.put(pos, 8);
        board = fillBitPosition (board,pos);
        //printBoard(board);
        freeBoard = freePosition(board);
        //System.out.println(freeBoard);
        positionsQueens = Queens(board, freeBoard, positionsQueens);
        return positionsQueens;
    }

    public static void main(String[] args){
        HashMap <Integer,Integer> board = new HashMap <>(); 
        board = fillBoardMap(); // формируем MAP позиций шахматной доски
        
        printBoard(board);
        
        Integer position1 = randFirstPosition(); // позиция ПЕРВОГО ферзя
        //Integer position1 = userFirstPosition();

        board.put(position1,8); // записываем "8" на позиции Ферзя на доске
        System.out.println("Позиция первого ферзя: " + position1);

        board = fillBitPosition(board,position1); // формируем МАР с учетом битых позиций
        //printBoard(board);
        
        HashSet <Integer> freeBoard = new HashSet <>(freePosition(board)); // формируем МАР свободных позиций
        //System.out.println(freeBoard);

        Stack<Integer> positionsQueens = new Stack<>(); // список для записи позиций ферзей
        positionsQueens = Queens(board, freeBoard, positionsQueens);
        //System.out.println(positionsQueens);
        printBoard(board);
    }
}
