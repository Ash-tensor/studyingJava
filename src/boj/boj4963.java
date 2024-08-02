package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj4963 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            scanner.nextLine();
            if ((w == 0) && (h == 0)) {
                break;
            }
            int[][] map = inputMethod(scanner, w, h);
            int[][] visitedNodes = new int[map.length][map[0].length];
            int counter = 0;

            for (int i = 0; i < map.length; i++) {
                for (int k = 0; k < map[0].length; k++) {
                    if ((visitedNodes[i][k] == 0) && (map[i][k] == 1)) {
                        dfs(new int[]{i, k}, map, visitedNodes);
                        counter++;
                    }
                }
            }
            System.out.println(counter);
        }
    }

    public static ArrayList<int[]> dfsWithNodes(int[] node, int[][] map,
                                                int[][] visitedNodes,
                                                ArrayList<int[]> islands) {

        visitedNodes[node[0]][node[1]] = 1;
        ArrayList<int[]> connectedNodes = getConnectedNodes(node, map, visitedNodes);

        if (connectedNodes.isEmpty()) {
            return islands;
        }
        else {
            for (int[] x : connectedNodes) {
                dfsWithNodes(x, map, visitedNodes, islands.add(x));

            }
        }

    }

    public static int dfs(int[] node, int[][] map, int[][] visitedNodes) {
        // 가로, 세로, 대각으로 연결되어 있는 사각형은 걸어 갈 수 있는 사각형임

        visitedNodes[node[0]][node[1]] = 1;
        ArrayList<int[]> connectedNodes = getConnectedNodes(node, map, visitedNodes);

        if (connectedNodes.isEmpty()) {
            return 1;
        }
        for (int[] x : connectedNodes) {
            dfs(x, map, visitedNodes);
        }
        return 0;
    }

    public static ArrayList<int[]> getConnectedNodes(int[] node, int[][] map, int[][] visitedNodes) {
        // 상, 좌대각, 좌, 좌하대각, 하, 우하대각, 우, 우상대각
        int[] x = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] y = {1, 1, 0, -1, -1, -1, 0, 1};
        int w = map[0].length;
        int h = map.length;

        ArrayList<int[]> connectedNode = new ArrayList<>();

        for(int i = 0; i < x.length; i++) {
            int[] temp = {node[0] + x[i], node[1] + y[i]};
            if ((temp[0] < 0) || (temp[0] >= h) || (temp[1] < 0) || (temp[1] >= w)) {}
            else {
                if (map[temp[0]][temp[1]] != 1) {
                    // 1이 아니면 아무것도 하지 않기
                }
                else {
                    // 1이면 추가
                    if (visitedNodes[temp[0]][temp[1]] != 1) {
                        // 방문하지 않았으면
                        connectedNode.add(temp);
                    }
                }
            }
        }
        return connectedNode;
    }

    public static int[][] inputMethod(Scanner scanner, int w, int h) {
        int[][] map = new int[h][w];
        for(int i = 0; i < h; i++) {
            for(int k = 0; k < w; k++) {
                map[i][k] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        return map;
    }
}
