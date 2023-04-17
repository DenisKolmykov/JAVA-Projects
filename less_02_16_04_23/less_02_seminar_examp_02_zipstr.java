package less_02_16_04_23;

//Напишите метод, который сжимает строку. 
// Пример: вход aaaabbbcddaaa.
// a4b3cd2a3

public class less_02_seminar_examp_02_zipstr {
    public static void main(String[] args) {
        String myStr = "aaaabbbcddaaa";
        System.out.println(strZip (myStr));
    }
    
    
    private static String strZip (String myStr) {
        StringBuilder res = new StringBuilder();
        char[] charArr = myStr.toCharArray();
        //char temp = charArr[0];
        int count = 1;
        res.append(charArr[0]);
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] == charArr[i-1]) {
                count++;
            }
            else {
                if (count !=1) res.append(count);
                count = 1;
                res.append(charArr[i]);
            }
        }
        if (count !=1) res.append(count);
        return res.toString();
    }
}
    

