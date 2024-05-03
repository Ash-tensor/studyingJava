package boj;

import java.util.ArrayList;
import java.util.Scanner;

class TheCase {
    int startPoint;
    int endPoint;

    public TheCase(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
}

public class boj1011 {
    static int caseNumber;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TheCase> cases = inputMethod(scanner);

        // 각 테스트 케이스에 대해 X 지점으로부터 Y 지점까지 정확히 도달하는데 필요한 최소한의
        // 공간이동 장치 작동 횟수를 출력

        // Bfs 하면 안 돼?

        ArrayList<Integer> answers = new ArrayList<>();
        for (int i = 0; i < caseNumber; i++) {
            answers.add(bfs());
        }




    }
    public static int bfs(TheCase testCase) {





    }
    public static ArrayList<TheCase> inputMethod(Scanner scanner) {
        int caseNumber = Integer.parseInt(scanner.nextLine());
        boj1011.caseNumber = caseNumber;

        ArrayList<TheCase> caseList = new ArrayList<>();

        for (int i = 0; i < caseNumber; i++) {
            int startPoint = scanner.nextInt();
            int endPoint = scanner.nextInt();
            scanner.nextLine();

            TheCase tempCase = new TheCase(startPoint, endPoint);
            caseList.add(tempCase);
        }
        return caseList;
    }
}
