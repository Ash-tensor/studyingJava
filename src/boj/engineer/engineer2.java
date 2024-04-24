package boj.engineer;

class Person {
    private String name;
    public static String staticName;
    public Person(String val) {
        name = val;
        staticName = val;

    }
    public static String get() {
//        return name; 이건 불가능하다 왜냐하면 name은 인스턴스 변수임으로
//        스태틱 메소드에서 출력할 수 없다.
        return staticName;
        // 스태틱네임은 출력 가능하다.
    }
    public void instanceGet() {
    }
    public void print() {
        instanceGet();
        this.instanceGet();
    }
}
public class engineer2 {
    static String name;
    public static final double Pi = 3.141592;
    final String c;

    public engineer2(String c) {
        this.c = c;
    }


    public static void main(String[] args) {
        engineer2.name = "this";
        Person person = new Person("me");
        System.out.println(person.staticName);
        //Static member 'boj.engineer.Person.staticName' accessed via instance reference
        System.out.println(Person.staticName);

    }
}
