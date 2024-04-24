package boj.engineer;

public class IsFieldExtends {
    public static void main(String[] args) {
        parentA pa = new sisterB();
        System.out.println(pa.name);
        pa.go();
//        Java에서는 메서드 호출 시 참조 변수의 타입을 기준으로 메서드를 선택합니다.
//        따라서 pa 객체를 통해 접근 가능한 메서드는 parentA 클래스에 정의된 메서드인 go() 메서드뿐입니다.
//        pa.go2();
    }
}

class parentA {
    String name;
    public parentA() {
        this.name = "A";
    }
    public void go() {
        System.out.println(name);
    }
}

class sisterB extends parentA {
    String name;
    public sisterB() {
        super();
        this.name = "B";
    }

    @Override
    public void go() {
        System.out.println(this.name);
    }

    public void go2() {
        System.out.println(this.name);
    }
}
