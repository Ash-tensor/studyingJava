package boj.engineer;

public class engineer7 {
    public static void main(String[] args) {
        int[] a = new int[8];

        int i = 0;
        int n = 10;
        while (i < 8) {
            a[i++] = n % 2;
            n /= 2;


        }

        for (int x : a){
            System.out.println(x);
        }
    }
}
