package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj1012 {
    // 연속된 섬을 찾는 문제
    public static boolean[][] visitedList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < caseNumber; i++) {
            int answer = solution(scanner);
            System.out.println(answer);
        }
    }

    public static int solution(Scanner scanner) {
        ArrayList<int[]> coordinates = inputMethod(scanner);
        int[] condition = coordinates.get(0);
        int[][] map = new int[condition[0]][condition[1]];
        visitedList = new boolean[condition[0]][condition[1]];

        for (int i = 1; i < coordinates.size(); i++) {
            int[] temp = coordinates.get(i);
            map[temp[0]][temp[1]] = 1;
        }

        int counter = 0;

        for (int i = 1; i < coordinates.size(); i++) {
            int[] temp = coordinates.get(i);
            if (!visitedList[temp[0]][temp[1]]) {
                dfs(map, temp);
                // 아 이거 섬의 크기를 리턴할 필요는 없구나
                // 일단 그대로 하자
                counter += 1;
            }
        }
        return counter;

    }
//    public static int dfs(int[][] map, int[] coordinate, int size) {
//        visitedList[coordinate[0]][coordinate[1]] = true;
//        ArrayList<int[]> connectedList = getConnectedList(map, coordinate);
//
//        if (connectedList.isEmpty()) {
//            return size;
//        }
//        else {
//            for (int[] x : connectedList) {
//                dfs(map, x, size++);
//            }
//        }
//        return size;
//    }

    public static int dfs(int[][] map, int[] coordinate) {
        visitedList[coordinate[0]][coordinate[1]] = true;
        int size = 1;  // 현재 위치도 크기에 포함

        ArrayList<int[]> connectedList = getConnectedList(map, coordinate);

        for (int[] next : connectedList) {
            if (!visitedList[next[0]][next[1]]) {
                size += dfs(map, next);
            }
        }
        return size;
    }


    public static ArrayList<int[]> getConnectedList(int[][] map, int[] coordinate) {
        int[] x = {0, 0, -1, +1}; // 상하좌우
        int[] y = {-1, +1, 0, 0}; // 상하좌우 방향 배열 선언

        ArrayList<int[]> answerList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int[] temp = {coordinate[0]+x[i], coordinate[1]+y[i]};
            if (temp[0] < 0 || temp[1] < 0 || (temp[0] > map.length - 1) || (temp[1] > map[0].length - 1)) {

            }
            else {
                if (map[temp[0]][temp[1]] == 1 && !visitedList[temp[0]][temp[1]]) {
                    answerList.add(temp);
                }
            }
        }
        return answerList;
    }

    public static ArrayList<int[]> inputMethod(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();

        ArrayList<int[]> coordinates = new ArrayList<>();
        int[] conditions = {x, y};
        coordinates.add(conditions);

        for (int i = 0; i < k; i++) {
            int[] temp = new int[2];
            temp[0] = scanner.nextInt();
            temp[1] = scanner.nextInt();
            scanner.nextLine();
            coordinates.add(temp);
        }

        return coordinates;
    }
}