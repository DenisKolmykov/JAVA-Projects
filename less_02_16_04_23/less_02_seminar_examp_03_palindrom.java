package less_02_16_04_23;
/*
 * Напишите метод, который принимает на вход строку (String) и 
определяет является ли строка палиндромом (возвращает boolean значение).
 */
public class less_02_seminar_examp_03_palindrom {
    public static void main(String[] args) {
        String myStr= "vfgrfv";
        System.out.println(palindrom(myStr));
    }
        
    
    private static Boolean palindrom(String myStr) {
        char[] charArr = myStr.toCharArray();
        int len = charArr.length;
        boolean flag = true;
        for (int i = 0; i < len / 2; i++) {
            if (charArr[i] != charArr[len-1-i]) {
                flag = false;
            }
        }
        //System.out.println(flag);
        return flag;           
    }
}

