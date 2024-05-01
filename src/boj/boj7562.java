package boj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class KnightNode {
    int[] coordinate;
    boolean[][] visitedNodes;
    public KnightNode(int[] coordinate, int boardLength) {
        this.coordinate = coordinate;
        this.visitedNodes = new boolean[boardLength][boardLength];
        this.visit(coordinate);
    }
    public KnightNode(int[] coordinate, boolean[][] visitedNodes) {
        this.coordinate = coordinate;
        this.visitedNodes = new boolean[visitedNodes.length][visitedNodes[0].length];
        for (int i = 0; i < visitedNodes.length; i++) {
            for (int j = 0; j < visitedNodes[i].length; j++) {
                this.visitedNodes[i][j] = visitedNodes[i][j];
            }
        }
    }
    public void visit(int[] coordinate) {
        this.visitedNodes[coordinate[0]][coordinate[1]] = true;
    }
    public boolean checkVisited(int[] coordinate) {
        // 방문했으면 참, 방문하지 않았으면 거짓
        if (this.visitedNodes[coordinate[0]][coordinate[1]]) {
            return true;
        }
        else {
            return false;
        }
    }
    public int getMovementNumber() {
        int answer = 0;
        for (boolean[] x : this.visitedNodes) {
            for (boolean y : x) {
                if(y) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
public class boj7562 {
    static int testCaseNumber;
    static ArrayList<ArrayList<int[]>> testCases = new ArrayList<>();
    static ArrayList<int[]> movementMetrix = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inputMethod(scanner);
        movementMetrix.add(new int[] {-2, -1});
        movementMetrix.add(new int[] {-2, 1});
        movementMetrix.add(new int[] {-1, -2});
        movementMetrix.add(new int[] {1, -2});
        movementMetrix.add(new int[] {-1, 2});
        movementMetrix.add(new int[] {+1, 2});
        movementMetrix.add(new int[] {2, -1});
        movementMetrix.add(new int[] {2, 1});

        for(ArrayList<int[]> testCase : testCases) {
            bfs(testCase);
        }
    }
    public static KnightNode bfs(ArrayList<int[]> testCase) {
        int[] boardLength = testCase.get(0);
        int[] nowPosition = testCase.get(1);
        int[] destination = testCase.get(2);

        ArrayDeque<KnightNode> model = new ArrayDeque<>();
        model.addLast(new KnightNode(nowPosition, boardLength[0]));

        while (model.size() != 0) {
            KnightNode selectedKnight = model.pollFirst();
            if (Arrays.equals(selectedKnight.coordinate, destination)) {
                return selectedKnight;
            }
            else {
                ArrayList<int[]> coordinates = getKnightMoves(boardLength[0],
                        selectedKnight.coordinate);

                for (int[] x : coordinates) {
                    if(selectedKnight.checkVisited(x)) {// 방문했으면 pass
                         }
                    else {
                        KnightNode tempKnight = new KnightNode(x, selectedKnight.visitedNodes);
                        tempKnight.visit(x);
                        model.addLast(tempKnight);
                    }
                }
            }
        }
        return null;
    }
    public static ArrayList<int[]> getKnightMoves(int boardLength, int[] coordinates) {
        ArrayList<int[]> returnArray = new ArrayList<>();
        for(int[] x : movementMetrix) {
            int[] tempCoordinates = new int[2];
            int i = 0;
            for(int y : x) {
                tempCoordinates[i] = coordinates[i++] + y;
            }
            if(checkBoardLimit(boardLength, tempCoordinates)) {
                // BoardLimit내에 위치하면
                returnArray.add(tempCoordinates);
            }
        }
        return returnArray;
    }
    public static boolean checkBoardLimit(int boardLength, int[] coordinate) {
        for (int x : coordinate) {
            if (x < 0) {
                return false;
            }
            else if (x > boardLength) {
                return false;
            }
        }
        return true;
    }
    public static void inputMethod(Scanner scanner) {
        boj7562.testCaseNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < boj7562.testCaseNumber; i++) {
            ArrayList<int[]> testCase = new ArrayList<>();
            int boardLength = scanner.nextInt();
            testCase.add(new int[] {boardLength});
            scanner.nextLine();

            for (int j = 0; j < 2; j++) {
                String coordinates = scanner.nextLine();
                int[] parsedLine = parsingString(coordinates);
                testCase.add(parsedLine);
            }
            testCases.add(testCase);
        }
    }
    public static int[] parsingString(String string) {
        String[] tempString = string.split(" ");
        int[] ints = new int[2];

        int i = 0;
        for (String x : tempString) {
            int temp = Integer.parseInt(x);
            ints[i++] = temp;
        }
        return ints;
    }
}
