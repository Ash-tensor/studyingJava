package boj;

public class sandbox {
    static int A=10;
    public static void main(String[] args) {
        System.out.println(sandbox.A);
        AB.D();
    }
}

class AB {
    public void C() {
        System.out.println(sandbox.A);
    }
    public static void D() {
        System.out.println(sandbox.A);
    }
}

