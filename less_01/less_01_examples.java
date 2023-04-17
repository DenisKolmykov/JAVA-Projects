package less_01;

/**
 * program
 */
public class less_01_examples {

    public static void main(String[] args) {
        System.out.println("hello");
        
        String s = "hello";
        System.out.println(s);
        
        int x = 12345;
        short y = 10;
        float z = 3.13123f;
        double a = 3.12345;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(a);
        
        char ch = '{';
        char cs = 123;
        System.out.println(ch);
        System.out.println(cs);
        
        boolean b = true ^ true;
        System.out.println(b);
        boolean f = true ^ true;
        System.out.println(f);
        boolean flag1 = 123<=234;
        System.out.println(flag1);
        boolean flag2 = 123 >= 234 || flag1;
        System.out.println(flag2);

        var v = 1234;
        System.out.println(v);
        System.out.println(getType(v));
        var m = 123.123;
        System.out.println(m);
        System.out.println(getType(m));

        m = 1234;
        System.out.println(m);

        String q = "qwerty";
        // q.charAt(1);
        System.out.println(q.charAt(1));

        int t = 123;
        System.out.println(t++); //постфиксный инкремент - приоритет у вывода, выше чем у постфиксного
        int u = 123;
        System.out.println(++u); // предфиксный инкремент - приоритет у префиксного выше, чем у вывода
    
        int [] arr = new int[5];
        System.out.println(arr.length);
        arr[3] = 15;
        System.out.println(arr[3]);

        int [] arr2 [] = new int [3][5];

        for (int[] line : arr2) {
            for (int item : line) {
                System.out.printf("%d",item);
            }
            System.out.println();
        }
                // или так : 
        int [][] arr3 = new int [3][5];
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.printf("%d", arr3[i][j]);
            }
            System.out.println();
        }
    
        String ss = "qwe";
        int p = 123;
        String r = ss + p;
        System.out.println(r);

        int aa = 1, bb = 2;
        int cc = aa + bb;
        String res = String.format("%d + %d = %d \n", aa, bb, cc);
        System.out.printf("%d + %d = %d\n", aa, bb, cc);
        System.out.println(res);



    }
    static String getType(Object o){
        return o.getClass().getSimpleName(); // класс для получения типа данных в предыдущих запросах getType
    }
}