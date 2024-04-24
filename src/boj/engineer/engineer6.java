package boj.engineer;

class parent {
    public void show() {
        System.out.println("parent");
    }
}

class child extends parent {
//    @Override
    public void show() {
        System.out.println("child");
    }
}

public class engineer6 {
    public static void main(String[] args) {
        parent pa = new child();
        pa.show();
    }
}
