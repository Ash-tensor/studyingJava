package boj;

import java.util.Arrays;
import java.util.Scanner;

public class newboj12100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] model = getInput(scanner);
        printBoard(model);



    }
    public static void printBoard(int[][] board) {
        for (int[] array : board) {
            for (int value : array) {
                System.out.printf("%d ", value);
            }
            System.out.println();
        }
    }
    public static int[][] getInput(Scanner scanner) {
        int[][] model;
        int width = scanner.nextInt();
        scanner.nextLine();
        model = new int[width][width];
        for (int i = 0; i < width; i++) {
            for (int k = 0; k < width; k++) {
                model[i][k] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        return model;
    }
    public static void upMove(int[][] board) {

    }
}
