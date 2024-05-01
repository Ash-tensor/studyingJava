package boj.engineer;

class p {
    public int calc(int n) {
        if (n <= 1) return n;
        return calc(n-1) + calc(n-2);
    }
}


class c extends p {
    public int calc(int n) {
        if (n <= 1) return n;
        return calc(n-1) + calc(n-3);
    }
}
public class engineer233 {
    public static void main(String[] args) {
        p obj = new c() ;
        System.out.print(obj.calc(7));

    }
}
