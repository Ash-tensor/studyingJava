package boj;

class A_g {
    int i;
    public A_g (int i) {
        this.i = i;
    }
    int get() {
        return i;
    }
}

class B_g extends A_g {
    int i;
    public B_g(int i) {
        super(2 * i);
        this.i = i;
    }
    int get() {
        return i;
    }

}
class C_g {
    int g;
    int f;

    public C_g() {}
}
public class engineer3 {
    public static void main(String[] args) {
        A_g ab = new B_g(7);
        C_g c = new C_g();
        System.out.println(ab.i + "," + ab.get());
        System.out.println(c.f);

        int d;
        int e = 10;
        int f = 11;
        overloadingTestMethod(e, f); //

//        System.out.println(d); << 초기화 하지 않은 변수는 출력할 수 없다.

    }
    public static int testSum(int ... values) {
        long first = (long) values[0];
        long second = (long) values[1];

        byte third = (byte) ((byte) first + (byte) second);

        return third;
    }
    public int testSumNotStatic (int ... values) {
        return 10;
    }
    public static int testMethod() {
        int a = testSum(1, 2, 3, 4, 5);
//        int c = testSumNotStatic(); << 이거 불가능함.
        return a;
    }
    public int testMethodNotStatic() {
        int a = testSum();
        int b = testSumNotStatic();
        return b;
    }
    public static double overloadingTestMethod(double a, double b) {
        double c = a + b;
        return c;
    }
}
