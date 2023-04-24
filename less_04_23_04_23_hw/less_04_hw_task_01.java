package less_04_23_04_23_hw;
// Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод(не void), который вернет “перевернутый” список

import java.util.LinkedList;
import java.util.Random;
public class less_04_hw_task_01 {
    public static void main(String[] args) {
        Random rand = new Random();
        int minPoint = 0;
        int maxPoint = 100;

        int initalLen = 10;

        LinkedList <Integer> myLList = new LinkedList<Integer>();
        for (int i = 0; i < initalLen; i++){
            myLList.add(rand.nextInt(minPoint,maxPoint));
        }
        System.out.println("original LinkedList: " + myLList);
        
        LinkedList <Integer> flipList = reverseLList (myLList);
        System.out.println("reverse  LinkedList: " + flipList);
    }


    private static LinkedList <Integer> reverseLList(LinkedList <Integer> ll) {
        LinkedList <Integer> reverseLL = new LinkedList<Integer>();
        for (int i = ll.size()-1; i >= 0; i--){
            reverseLL.add(ll.get(i));
        }
        return reverseLL;
    }
}
