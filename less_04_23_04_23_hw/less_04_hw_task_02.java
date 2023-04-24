package less_04_23_04_23_hw;
/*
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.

Пример:
[1, 2, 3, 4, 5, 6, 7]
spisok.enqueue(8)
[1, 2, 3, 4, 5, 6, 7,8]
spisok.dequeue
1
[2, 3, 4, 5, 6, 7,8]
spisok.first()
2
[2, 3, 4, 5, 6, 7,8]
 */

import java.util.LinkedList;
import java.util.Random;

public class less_04_hw_task_02 {
    public static void main(String[] args) {

        MyQueue spisok = new MyQueue();
        spisok.length = 10; // задаем длину списка для первоначального формирования
        spisok.elem = spisok.create(); // создание списка
        System.out.println("Создан список:\n" + spisok.elem);
        
        int num = -100; // число для добавления в список
        spisok.elem = spisok.enqueue(num);
        System.out.println("Список после добавления числа " + num + " :\n" + spisok.elem);

        spisok.elem = spisok.dequeue();
        System.out.println("Список поле удаления первого элемента:\n" + spisok.elem);
        
        spisok.first();
        System.out.println("Список после вывода первого элемента без удаления:\n" + spisok.elem);
    }
}

    
class MyQueue {
    int length;
    LinkedList <Integer> elem;

    
    LinkedList <Integer> create (){
        LinkedList <Integer> elem = new LinkedList<>();
        Random rand = new Random();
        int minPoint = 0;
        int maxPoint = 100;
        for (int i = 0; i < length; i++){
            elem.add(rand.nextInt(minPoint,maxPoint));
        }
        return elem;
    }


    LinkedList <Integer> enqueue(int addNum){
        elem.add(addNum);
        return elem;
    }

       
    LinkedList <Integer>  dequeue() {
        System.out.println("удален первый элемент: " + elem.pop());
        return elem;
    }

    LinkedList <Integer>  first() {
        System.out.println("первый элемент: " + elem.peekFirst());
        return elem;
    }
}

    


