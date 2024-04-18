package boj;

public class PrivateTest {
    private PrivateTest() {
    }
}

class TestClass {
    private int me;
    public int mea;
    public static int mes = 20;
    public void me1() {}
    private void me2() {}

    public TestClass(String args, String beta) {

    }
}

class TestClass2 extends TestClass {
    public int c = 10;
    public int mec;

    public TestClass2(String args, String beta) {
        super(args, beta);
    }
    public void TestClass2() {
        this.mec = super.mea;
    }
}