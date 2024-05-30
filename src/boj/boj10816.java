package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class boj10816 {
    static int N;
    static int M;
    static int mid;
    static ArrayList<Integer> cards;
    static ArrayList<Integer> targets;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inputMethod(scanner);

        // 파라메트릭 서치 문제임


    }
    // 타겟이 search에 있는가 없는가. 이거 정렬해야하는거 아님?
    public static boolean solution(int target) {
        // 기준점을 잡아야겠네

    }

    public static void inputMethod(Scanner scanner) {
        N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            cards.add(scanner.nextInt());
            scanner.nextLine();
        }

//      이진탐색을 위한 정렬
        cards.sort(Comparator.naturalOrder());
//        cards.sort((a, b) -> (a - b));

        M = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            targets.add(scanner.nextInt());
            scanner.nextLine();
        }
//      이진 탐색을 위한 정렬
        targets.sort(Comparator.naturalOrder());

        mid = cards.size() / 2;

    }
}
