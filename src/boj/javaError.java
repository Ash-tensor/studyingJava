package boj;

public class javaError {
    public static void main(String[] args) {
        try {
            System.out.println("A");
            foo();
            System.out.println("B");
        }

        catch (Exception e) {
            System.out.println("C");
        }
        System.out.println("D");
    }

    public static void foo() throws Exception {
        try {
            System.out.println("E");
            throw new Exception();
        }
        catch (Exception e) {
            System.out.println("F");
            throw e;
        }
        finally {
            System.out.println("G");
        }
    }
}
