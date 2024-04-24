package boj.engineer;

public class Engineer22_2 {
    int a;
    public Engineer22_2(int a) {
        this.a = a;
    }

    int func() {
        int b = 1;
        for (int i = 1; i < a; i++) {
            b = a * i + b;
        }
        return a + b;
    }

    public static void main(String[] args) {
        Engineer22_2 obj = new Engineer22_2(3);
        obj.a = 5;
        int b = obj.func();
        System.out.println(obj.a + b);
    }

}
