package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// 숫자 카드 2

// 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
// 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하세요

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
        int middle = mid;
        int max = cards.size();
        // 기준점을 잡아야겠네
        while(true) {
            if (target < middle) {
                middle /= 2;
            }
            else if(target > middle) {
                int temp = middle + cards.size();
                middle = temp / 2;
            }

        }

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
