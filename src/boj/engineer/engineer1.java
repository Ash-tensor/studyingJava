package boj.engineer;

public class engineer1 {
    public static void main(String[] args) {
        A_e obj = new C_e();
        obj.f();
        obj.g();
        System.out.println();
        B_e obj1 = new C_e();
        obj1.f();
        obj1.g();
        B_e.g(); // 이래야 되는거 아니야?

    }
}
class A_e {
    public void f() {
        System.out.print("1 ");
    }
    public static void g() {
        System.out.print("2 ");
    }
}

class B_e extends A_e {
    public void f() {
        System.out.print("3 ");
    }
    public static void g() {
        System.out.print("4 ");
    }
}

class C_e extends B_e {
    public void f() {
        System.out.print("5 ");
    }
    public static void g() {
        System.out.print("6 ");
    }
}