package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj1018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
    public static void inputSetter(Scanner scanner) {
        String boardMax = scanner.nextLine();
        ArrayList<String> condition = new ArrayList<>
                (Arrays.asList(boardMax.split(" ")));

        int[] BoardCondition = new int[2];

        for (String x : condition) {
            Integer.parseInt(x);
        }

    }


}
