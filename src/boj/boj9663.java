package boj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class boj9663 {
    static int N;
    static boolean[][] map;
    static boolean[][] visited;
    static int finalAnswer = 0;
    static ArrayList<ArrayDeque<int[]>> answerList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new boolean[N][N];
        visited = new boolean[N][N];
        cleanMap();

        ArrayList<int[]> firstDepth = connectedNodeChecker();
        for(int[] C : firstDepth) {
            dfs(C[0], C[1], new ArrayDeque<>());
        }
        System.out.println(finalAnswer);
    }

    public static void dfs(int x, int y, ArrayDeque<int[]> queenList) {
        ArrayDeque<int[]> dfsQueenList = new ArrayDeque<>(queenList);
        int[] nowCoordinate = {x, y};
        dfsQueenList.add(nowCoordinate);
        visited[x][y] = true;
        positioningQueen(dfsQueenList);
        ArrayList<int[]>connectedList = connectedNodeChecker();
        if (dfsQueenList.size() == N) {

            // check the queen's location
            for (int[] queenCoordinate : dfsQueenList) {
                System.out.print(queenCoordinate[0] + " " + queenCoordinate[1] + " ");
            }
            System.out.println();
            answerList.add(dfsQueenList);
            finalAnswer++;
            return;
        }

        if (connectedList.isEmpty()) {
            return;
        }
        else {
            for(int[] queenCoordinate : connectedList) {
                dfs(queenCoordinate[0], queenCoordinate[1], dfsQueenList);
            }
        }
    }

    public static void cleanMap() {
        for(int i = 0; i < N; i++) {
            for(int k = 0; k < N; k++) {
                map[i][k] = true;
            }
        }
    }
    public static void finalDiagonalMove(int x, int y) {
        diagonalMove1(x, y);
        diagonalMove2(x, y);
        diagonalMove3(x, y);
        diagonalMove4(x, y);
    }
    public static void diagonalMove1(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return ;
        }
        else {
            map[x][y] = false;
            diagonalMove1(x + 1, y + 1);
        }
    }
    public static void diagonalMove2(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return ;
        }
        else {
            map[x][y] = false;
            diagonalMove2(x - 1, y - 1);
        }
    }
    public static void diagonalMove3(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return ;
        }
        else {
            map[x][y] = false;
            diagonalMove3(x + 1, y - 1);
        }
    }
    public static void diagonalMove4(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return ;
        }
        else {
            map[x][y] = false;
            diagonalMove4(x - 1, y + 1);
        }
    }
    public static void markQueenMove(int x, int y) {
        //가로 또는 세로축에 퀸을 배치
        for(int i = 0; i < N; i++) {
            for(int k = 0; k < N; k++) {
                if(i == x || k == y) {
                    map[i][k] = false;
                }
            }
        }
        finalDiagonalMove(x, y);
    }
    public static void positioningQueen(ArrayDeque<int[]> queenList) {
        // let queen to place in map // that's finally set the map's node to true or false

        cleanMap();
        for (int[] queenCoordinate : queenList) {
            markQueenMove(queenCoordinate[0], queenCoordinate[1]);
        }
    }
    public static ArrayList<int[]> connectedNodeChecker() {



        ArrayList<int[]> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (map[i][k]) {
                    int[] temp = {i, k};
                    answer.add(temp);
                }
            }
        }
        return answer;
    }
}
