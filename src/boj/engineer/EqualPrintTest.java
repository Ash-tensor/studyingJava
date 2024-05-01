package boj.engineer;

public class EqualPrintTest {
    public static void main(String[] args) {
        String str1 = "P";
        String str2 = "P";
        String str3 = new String("P");

        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));
    }
}
