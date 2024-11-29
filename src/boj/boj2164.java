package boj;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class boj2164 {
    public static void main(String[] args) {
        Stack<Integer> cardStack = inputMethod();
        ArrayDeque<Integer> cardDeque = new ArrayDeque<>(cardStack);
        while(cardDeque.size() > 1) {
            int targetCard = cardDeque.pop();
            if(targetCard % 2 == 0) {
                cardDeque.addFirst(targetCard);
            }
        }

        int answer = cardDeque.pop();
        System.out.println(answer);
    }

    public static Stack<Integer> inputMethod() {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        Stack<Integer> cardStack = new Stack<>();
        for(int i = 1; i <= repeat; i++) {
            cardStack.push(i);
        }
        Stack<Integer> sortedCardStack = cardStack.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(Stack::new));

        return sortedCardStack;
    }
}
