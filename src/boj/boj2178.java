package boj;

import java.util.*;

public class boj2178 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] condition = new int[2];
        condition[0] = scanner.nextInt();
        condition[1] = scanner.nextInt();
        scanner.nextLine();

        int[][] theMap = new int[condition[0]][condition[1]];
        for(int i = 0; i < condition[0]; i++) {
            String temp = scanner.nextLine();
            for(int j = 0; j < temp.length(); j++) {
                theMap[i][j] = temp.charAt(j) - '0';
            }
        }

        int[] startNode = {0, 0};
        int[] goal = {condition[0] - 1, condition[1] - 1};
        int answer = bfsToGoal(theMap, startNode, goal);
        System.out.println(answer);
    }

    public static ArrayList<int[]> connectedNodeChecker(int[][] theMap, int x, int y) {
        ArrayList<int[]> valuedConnectedNode = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < theMap.length && 0 <= ny && ny < theMap[0].length && theMap[nx][ny] == 1) {
                int[] temp = {nx, ny};
                valuedConnectedNode.add(temp);
            }
        }
        return valuedConnectedNode;
    }

    public static int bfsToGoal(int[][] theMap, int[] startNode, int[] goal) {
        Queue<ArrayList<int[]>> openList = new LinkedList<>();
        boolean[][] visitedSet = new boolean[theMap.length][theMap[0].length];
        ArrayList<int[]> tempStartNode = new ArrayList<>();
        tempStartNode.add(startNode);
        openList.add(tempStartNode);
        visitedSet[startNode[0]][startNode[1]] = true;

        while (!openList.isEmpty()) {
            ArrayList<int[]> selectedNode = openList.poll();
            int[] lastSelectedNode = selectedNode.get(selectedNode.size() - 1);
            if (Arrays.equals(lastSelectedNode, goal)) {
                return selectedNode.size();
            }

            ArrayList<int[]> connectedNodeList = connectedNodeChecker(theMap, lastSelectedNode[0], lastSelectedNode[1]);
            for(int[] i : connectedNodeList) {
                if (!visitedSet[i[0]][i[1]]) {
                    visitedSet[i[0]][i[1]] = true;
                    ArrayList<int[]> clonedSelectedNode = new ArrayList<>(selectedNode);
                    clonedSelectedNode.add(i);
                    openList.add(clonedSelectedNode);
                }
            }
        }
        return -1;
    }
}
