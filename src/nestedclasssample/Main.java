package nestedclasssample;

public class Main {
    public static void main(String[] args) {

        System.out.println("객체 생성");
        Korea.Korean A = new Korea.Korean("한국인", "Male", "KOREA");
        US.American B = new US.American("미국인", "Female", "US");
        NorthKorea.NorthKorean C = new NorthKorea.NorthKorean("북한인", "Male", "NorthKorea");

        A.birthRegistration();
        B.birthRegistration();
        C.birthRegistration();


        System.out.printf("현재 %s의 위치 : %s\n", A.name, A.region);
        System.out.printf("현재 %s의 위치 : %s\n", B.name, B.region);

        System.out.println("\n* 한국인의 미국 방문 상황 :");

        A.tourAbroad(US.getInstance());

        System.out.println("\n* 미국인의 한국 방문 상황 :");

        B.tourAbroad(Korea.getInstance());
        // C는 ILibertyToMove(이동할 자유)를 구현하지 않기 때문에 .tourAbroad 할 수 없다.
        System.out.println("\n* 북한 방문 상황 :");

        // NorthKorea는 IVisitable interface를 구현하지 않기 때문에 방문할 수 없다.
        A.tourAbroad(NorthKorea.getInstance());
        B.tourAbroad(NorthKorea.getInstance());


        System.out.printf("* 현재 %s의 위치 : %s\n", A.name, A.region);
        System.out.printf("* 현재 %s의 위치 : %s\n", B.name, B.region);

        System.out.println("\n* Situation Immigration :");

        A.Immigrate(US.getInstance());

    }
}
