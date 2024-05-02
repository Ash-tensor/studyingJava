package boj;

//import java.lang.management.ManagementFactory;
//import java.lang.management.MemoryMXBean;
//import java.lang.management.MemoryUsage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class KnightNode2 {
    int[] coordinate;
    int[][] visitedNodes;
    int depth = 0;
    public KnightNode2(int[] coordinate, int boardLength) {
        this.coordinate = coordinate;
        this.visitedNodes = new int[boardLength][boardLength];
        this.visit(coordinate);
    }
    public KnightNode2(int[] coordinate, int[][] visitedNodes, int depth) {
        this.coordinate = coordinate;
        this.visitedNodes = visitedNodes;
        this.depth = depth;
    }

    public void visit(int[] coordinate) {
        this.visitedNodes[coordinate[0]][coordinate[1]] = 1;
    }
    public boolean checkVisited(int[] coordinate) {
        // 방문했으면 참, 방문하지 않았으면 거짓
        if (this.visitedNodes[coordinate[0]][coordinate[1]] == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
public class newboj7562 {
    static int testCaseNumber;
    static ArrayList<ArrayList<int[]>> testCases = new ArrayList<>();
    static ArrayList<int[]> movementMetrix = new ArrayList<>();
    static int[][] visitedList;

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
            KnightNode2 answerKnight = bfs(testCase);
            System.out.println(answerKnight.depth);

//            MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
//            MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
//            MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();
//
//            System.out.println("Heap Memory Usage:");
//            System.out.println("    Init: " + heapMemoryUsage.getInit() / (1024 * 1024) + " MB");
//            System.out.println("    Used: " + heapMemoryUsage.getUsed() / (1024 * 1024) + " MB");
//            System.out.println("    Committed: " + heapMemoryUsage.getCommitted() / (1024 * 1024) + " MB");
//            System.out.println("    Max: " + heapMemoryUsage.getMax() / (1024 * 1024) + " MB");
//
//            System.out.println("Non-Heap Memory Usage:");
//            System.out.println("    Init: " + nonHeapMemoryUsage.getInit() / (1024 * 1024) + " MB");
//            System.out.println("    Used: " + nonHeapMemoryUsage.getUsed() / (1024 * 1024) + " MB");
//            System.out.println("    Committed: " + nonHeapMemoryUsage.getCommitted() / (1024 * 1024) + " MB");
//            System.out.println("    Max: " + nonHeapMemoryUsage.getMax() / (1024 * 1024) + " MB");
        }
    }
    public static KnightNode2 bfs(ArrayList<int[]> testCase) {
        int[] boardLength = testCase.get(0);
        int[] nowPosition = testCase.get(1);
        int[] destination = testCase.get(2);

        visitedList = new int[boardLength[0]][boardLength[0]];

        ArrayDeque<KnightNode2> model = new ArrayDeque<>();
        model.addLast(new KnightNode2(nowPosition, boardLength[0]));

        while (model.size() != 0) {
            KnightNode2 selectedKnight = model.pollFirst();
//            System.out.printf("%d, %d\n", selectedKnight.coordinate[0], selectedKnight.coordinate[1]);
            if (Arrays.equals(selectedKnight.coordinate, destination)) {
                return selectedKnight;
            }
            else {
                ArrayList<int[]> coordinates = getKnightMoves(boardLength[0],
                        selectedKnight.coordinate);

                for (int[] x : coordinates) {
//                    System.out.printf("::%d, %d\n",x[0], x[1]);
                    if(selectedKnight.checkVisited(x)) {// 방문했으면 pass
                    }
                    else {
                        KnightNode2 tempKnight = new KnightNode2(x, selectedKnight.visitedNodes, selectedKnight.depth + 1);
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
            else if (x >= boardLength) {
                return false;
            }
        }
        return true;
    }
    public static void inputMethod(Scanner scanner) {
        newboj7562.testCaseNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < newboj7562.testCaseNumber; i++) {
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
