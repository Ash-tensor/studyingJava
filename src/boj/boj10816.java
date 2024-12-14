package boj;

import java.lang.reflect.Array;
import java.util.*;

public class boj10816 {
    static int[] intCards;
    static int[] intTargetCards;
    static List<Integer> sortedCards;
    static List<Integer> sortedTargetCards;
    static int cardNumber;
    static int targetCardNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inputMethod(scanner);
        solution();

    }
    public static void solution() {
        HashMap<Integer, Integer> cardMap = new HashMap<>();
        for (int x : intTargetCards) {
            cardMap.put(x, 0);
        }

        for (int x : intCards) {
            int nowNumber = cardMap.getOrDefault(x, 0);
            cardMap.put(x, nowNumber + 1);
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < intTargetCards.length; i++) {
            int targetNumber = cardMap.get(intTargetCards[i]);
            if (i == intTargetCards.length - 1) {
                answer.append(targetNumber);

            }
            else {
                answer.append(targetNumber);
                answer.append(" ");
            }

        }

        System.out.print(answer);
    }

    public static void inputMethod(Scanner scanner) {
        cardNumber = Integer.parseInt(scanner.nextLine());
        String cardString = scanner.nextLine();
        String[] cards = cardString.split(" ");

        intCards = Arrays.stream(cards).mapToInt(Integer::parseInt).toArray();

        targetCardNumber = Integer.parseInt(scanner.nextLine());

        String targetCardString = scanner.nextLine();
        String[] targetCards = targetCardString.split(" ");

        // 이건 순서대로 정렬되어 있을 것 같은데
        intTargetCards = Arrays.stream(targetCards).mapToInt(Integer::parseInt).toArray();

        sortedCards = new ArrayList<>();
        sortedTargetCards = new ArrayList<>();

        for (int x : intCards) {
            sortedCards.add(x);
        }
        for (int x : intTargetCards) {
            sortedTargetCards.add(x);
        }


        sortedCards.sort(Comparator.naturalOrder());
        sortedTargetCards.sort(Comparator.naturalOrder());
    }


    }