package boj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class boj3040 {
    public static void main(String[] args) {
        int repeat = 9;
        Scanner scanner = new Scanner(System.in);
        int[] dworfs = new int[9];


        for(int i = 0; i < repeat; i++) {
            dworfs[i] = scanner.nextInt();
            scanner.nextLine();
        }



    }
    public static ArrayList<Integer> solution(int[] dworfs, int startNode) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        Stack<ArrayList<Integer>> openList = new Stack<>();
        ArrayList<Integer> firstNode = new ArrayList<>(dworfs[startNode]);

        openList.add(firstNode);

        while(true) {
            if (openList.size() == 0) {
                return -1;
            }
            else {
                ArrayList<Integer> selectedNode = openList.pop();
                if (selectedNode.size() == 7) {
                    int condition = 0;
                    for(int i : selectedNode) {
                        condition += i;
                    }
                    if (condition == 100) {
                        return selectedNode;
                    }

                }


            }

        }


    }

}
