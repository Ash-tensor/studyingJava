package boj;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
    ArrayDeque<ArrayList<Integer>> answer = BFS();
    for (ArrayList<Integer> i : answer) {
        for (Integer c : i) {
            System.out.printf("%d ", c);
        }
        System.out.println();
    }

    }
    public static ArrayDeque<ArrayList<Integer>> BFS() {
        int[] problemSpace = {0,1,2,3};
        ArrayDeque<ArrayList<Integer>> openList = new ArrayDeque<>();
        ArrayDeque<ArrayList<Integer>> closedList = new ArrayDeque<>();

        for (int i = 0; i < problemSpace.length; i++) {
            int tempNode = problemSpace[i];
            ArrayList<Integer> tempArray = new ArrayList<>();
            tempArray.add(tempNode);
            openList.add(tempArray);
        }

        while (true) {
            if (openList.size() == 0) {
                return closedList;
            }
            else {
                ArrayList<Integer> selectedNode = openList.pollFirst();
                if (selectedNode.size() == 5) {
                    closedList.add(selectedNode);
                }
                else {
                    for (int i : problemSpace) {
                        ArrayList<Integer> clonedSelectedNode = new ArrayList<>(selectedNode);
                        clonedSelectedNode.add(i);
                        openList.add(clonedSelectedNode);
                    }
                }
            }
        }
    }
}
