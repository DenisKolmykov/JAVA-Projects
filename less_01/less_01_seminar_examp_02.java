package less_01;
// Дан массив nums = [3,2,4,3,2,5,3] и число val = 3. 
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива. 
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
// Не создаём доп.массив
// [2,4,2,5,3,3,3]

import java.util.Arrays;

public class less_01_seminar_examp_02 {
    public static void main(String[] args) {
        int[] arr = new int [] {3,2,4,3,2,5,3,6};
        int val = 3;
        int len = arr.length;

        //int lenj = len;

        //int temp = arr [0];
        int i = 0;
        while (len>0){
        //for (int i = 0; i < len; i++) {
            int x = 0;
            if (arr[i] == val) {

                for (int j = i; j < len-1; j++) {
                    arr[j] = arr [j+1];
                    System.out.println(arr[j]);
                }
                //arr[arr.length-i-1] = arr[arr.length-1];
                //i--;
                arr[arr.length-1-x] = val;
                x++;
                len--;

            }

            //len--;
            else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    
}  

