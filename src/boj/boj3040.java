package boj;
import java.util.*;

public class boj3040 {
    public static void main(String[] args) {
        int repeat = 9;
        Scanner scanner = new Scanner(System.in);
        int[] dworfs = new int[9];


        for(int i = 0; i < repeat; i++) {
            dworfs[i] = scanner.nextInt();
            scanner.nextLine();
        }

        ArrayList<Integer> answer = solution(dworfs);
        for(int i : answer) {
            System.out.println(i);
        }

    }

    public static ArrayList<Integer> solution(int[] dworfs) {
        int repeated = 0;
        while (true) {
            ArrayList<Integer> answer = dfs(dworfs, repeated);
            if (answer == null) {
                repeated ++;
            }
            else {
                return answer;
            }
        }

    }

    public static ArrayList<Integer> dfs(int[] dworfs, int startNode) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        Stack<ArrayList<Integer>> openList = new Stack<>();
        ArrayList<Integer> firstNode = new ArrayList<>();
        firstNode.add(dworfs[startNode]);

        openList.add(firstNode);

        while(true) {
            if (openList.size() == 0) {
                return null;
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
                else {
                    for (int i = startNode+1; i < dworfs.length; i++) {
                        if (!selectedNode.contains(dworfs[i])) {
                            ArrayList<Integer> copyedSelectedNode = new ArrayList<>(selectedNode);
                            copyedSelectedNode.add(dworfs[i]);
                            openList.push(copyedSelectedNode);
                        }
                    }
                }
            }
        }
    }
}
