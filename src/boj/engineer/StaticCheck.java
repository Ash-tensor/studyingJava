package boj.engineer;

public class StaticCheck {
    public static void main(String[] args) {
        System.out.println(StaticCheck.check(1));
    }
    static String check(int num) {
        return (num >= 0) ? "Positive" : "negative";
    }
}
