package boj;

import java.util.*;

public class newboj1743 {
    static int[] MAX_AMOUNT;
    static HashSet<ArrayList<Integer>> visitedNodes = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> condition = setCondition(scanner);
        ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();

        for (int i = 1; i < condition.size(); i++) {
            nodeList.add(condition.get(i));
        }

        MAX_AMOUNT = new int[nodeList.size()];
        for (int i = 0; i < MAX_AMOUNT.length; i++) {
            MAX_AMOUNT[i] = 1;
        }

        for (ArrayList<Integer> node : nodeList) {
            if (!visitedNodes.contains(node)) {
                dfs(node, nodeList, condition.get(0), nodeList.indexOf(node));
            }
        }

        OptionalInt max = Arrays.stream(MAX_AMOUNT).max();
        int answer = max.getAsInt();
        System.out.println(answer);


    }

    public static ArrayList<ArrayList<Integer>> setCondition(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int repeat = scanner.nextInt();
        scanner.nextLine();

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> condition = new ArrayList<>();
        condition.add(x);
        condition.add(y);
        answer.add(condition);

        for (int i = 0; i < repeat; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(first);
            temp.add(second);

            answer.add(temp);

        }
        return answer;
    }

    public static ArrayList<ArrayList<Integer>> connectedNodeChecker
            (ArrayList<Integer> node, ArrayList<Integer> limit, ArrayList<ArrayList<Integer>> condition) {

        int[] xDirections = {-1, 1, 0, 0};
        int[] yDirections = {0, 0, -1, 1};

        int x = node.get(0);
        int y = node.get(1);

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int calculatedX = x + xDirections[i];
            int calculatedY = y + yDirections[i];

            if (calculatedX < 1 || calculatedX > limit.get(0) ||
            calculatedY < 1 || calculatedY > limit.get(1)) {
            }
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(calculatedX);
                temp.add(calculatedY);

                if (condition.contains(temp)) {
                    answer.add(temp);
                }
            }
        }
        return answer;
    }

    public static void dfs(ArrayList<Integer> node, ArrayList<ArrayList<Integer>> nodeList,
                           ArrayList<Integer> limit, int number) {
        visitedNodes.add(node);
        ArrayList<ArrayList<Integer>> connectedNodes = connectedNodeChecker(node, limit, nodeList);

        if (connectedNodes.size() == 0) {
            return;
        }
        else {
            for (ArrayList<Integer> connectedNode : connectedNodes) {
                if (!visitedNodes.contains(connectedNode)) {
                    MAX_AMOUNT[number] += 1;
                    dfs(connectedNode, nodeList, limit, number);
                }
            }
        }
    }
}
