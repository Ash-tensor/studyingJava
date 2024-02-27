package boj;

import java.util.*;

public class boj1743 {

    static int[] max_amount;
    static HashSet<int[]> visitedNodes = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<int[]> condition = setCondition(scanner);
        ArrayList<int[]> nodeList = new ArrayList<>();

        for(int i = 1; i < condition.size(); i++) {
            nodeList.add(condition.get(i));
        }

//        condition.stream().forEach(x -> System.out.printf("[%d, %d]\n", x[0], x[1]));
//        connectedNodeChecker(condition.get(1), condition.get(0),
//                condition).forEach(x -> System.out.printf("[%d, %d]\n", x[0], x[1]));

        max_amount = new int[condition.size()-1];
        for (int i = 0; i < max_amount.length; i++) {
            max_amount[i] = 1;
        }

//        condition << 0번 인덱스 이후부터 계산해야함

        for (int[] node : nodeList) {
            if (!visitedNodes.contains(node)) {
//            if (!containsArray(visitedNodes, node)) {
                dfs(node, nodeList, condition.get(0), nodeList.indexOf(node));
            }
        }

        OptionalInt max = Arrays.stream(max_amount).max();
        System.out.println(max);


    }

    public static ArrayList<int[]> setCondition(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int repeat = scanner.nextInt();
        scanner.nextLine();

        ArrayList<int[]> answer = new ArrayList<>();
        int[] condition = {x, y};
        answer.add(condition);

        for(int i = 0; i < repeat; i++) {
           int first = scanner.nextInt();
           int second = scanner.nextInt();
           int[] temp = {first, second};
           answer.add(temp);
        }
        return answer;
    }
    public static boolean containsArray(ArrayList<int[]> arrayList, int[] array) {
        for (int[] arr : arrayList) {
            if (Arrays.equals(arr, array)) {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<int[]> connectedNodeChecker(int[] node, int[] limit,
                                                        ArrayList<int[]> conditions) {
        ArrayList<int[]> condition = new ArrayList<>();
        for (int i = 1; i < conditions.size(); i++) {
            condition.add(conditions.get(i));
        }

        // 상하좌우 순서대로 방향배열 설정
        int[] xDirection = {-1, 1, 0, 0};
        int[] yDirection = {0, 0, -1, 1};

        int x = node[0];
        int y = node[1];

        ArrayList<int[]> answer = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int calculatedX = x + xDirection[i];
            int calculatedY = y + yDirection[i];

            // 문제에서 문제공간이 1부터 시작하므로 조정

            if (calculatedX < 1 || calculatedX > limit[0] ||
                    calculatedY < 1 || calculatedY > limit[1]) {
            }
            else {
                int[] temp = {calculatedX, calculatedY};
                if (containsArray(condition, temp)) {
                    answer.add(temp);
                }
            }
        }

        return answer;
    }
    public static void dfs(int[] node, ArrayList<int[]> questList, int[] limit, int number) {
        visitedNodes.add(node);
        ArrayList<int[]> connectedNodes = connectedNodeChecker(node, limit, questList);
        if (connectedNodes.size() == 0) {
            return;
        }
        else {
            for (int[] connectedNode : connectedNodes) {
                if (!visitedNodes.contains(connectedNode)) {
                    max_amount[number] += 1;
                    dfs(connectedNode, questList, limit, number);
                }
            }
        }
    }
}



