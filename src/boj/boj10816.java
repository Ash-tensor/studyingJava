package boj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj10816 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> question = boj10816.inputMethod(scanner);
        int[] cards = question.get(0);
        int[] targetCards = question.get(1);

        ArrayList<Integer> sortedCards = new ArrayList<>();
        for (int x : cards) {
            sortedCards.add(x);
        }
        sortedCards = quickSort(sortedCards);







    }
    public static Object binarySearch(ArrayList<Integer> targetArray, int targetNumber) {
        // targetArray는 정렬되어 있다고 가정

        int middle = targetArray.size() / 2;
        int point = targetArray.get(middle);

        if (targetNumber < point) {
            List<Integer> complexSpace = targetArray.subList(0, middle);
            binarySearch(complexSpace)
        }


    }


    public static ArrayList<Integer> quickSort(ArrayList<Integer> cards) {
        if (cards.size() <= 1) {
            return cards;
        }

        // 정렬되면 끝
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> bigger = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();

        int point = cards.get(0);

        for (int x : cards) {
            if (x == point) {
                equal.add(x);
            }
            else {
                // x가 기준점보다 작으면
                if (x < point) {
                    smaller.add(x);
                }
                else {
                    bigger.add(x);
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>(quickSort(smaller));
        answer.addAll(equal);
        answer.addAll(quickSort(bigger));

        return answer;
    }


    public static ArrayList<int[]> inputMethod(Scanner scanner) {
        int n = scanner.nextInt();
        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] targetCards = new int[m];

        for (int i = 0; i < m; i++) {
            targetCards[i] = scanner.nextInt();
        }

        ArrayList<int[]> question = new ArrayList<>();
        question.add(cards);
        question.add(targetCards);

        return question;

    }

}