package less_02_16_04_23;
/*
 * Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет строку длины N, 
которая состоит из чередующихся символов c1 и c2, начиная с c1.
6
a b
ababab
 */
public class less_02_seminar_examp_01 {
    public static void main(String[] args) {
        int n = 6;
        String c1 = "a";
        String c2 = "b";
        System.out.println(strBuild (n, c1, c2));
    }
        
    
    private static String strBuild (int n, String c1, String c2) {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n / 2; i++) {
            res.append(c1 + c2);
        }
        return res.toString();
    }
}

