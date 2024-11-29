package boj;
import java.util.*;
import java.util.stream.Collectors;

public class boj2606 {
    static int nodeCount;
    static ArrayList<Boolean> visitedList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, List<Integer>> connectedMap = inputMethod(scanner);
        visitedList = new ArrayList<>(Collections.nCopies(nodeCount, false));

        dfs(1, connectedMap);

        long trueCount = visitedList.stream()
                .filter(x -> x == true)
                .count();

        System.out.println(trueCount - 1);
    }

    public static void dfs(int currentNode, HashMap<Integer, List<Integer>> connectedMap) {
        if (visitedList.get(currentNode - 1)) {
            return;
        }

        visitedList.set(currentNode - 1, true);
        List<Integer> connectedList = connectedNodes(currentNode, connectedMap);
        for (int nextNode : connectedList) {
            if (!visitedList.get(nextNode - 1)) { // 인덱스 수정
                dfs(nextNode, connectedMap);
            }
        }
    }

    public static List<Integer> connectedNodes(int targetNode, HashMap<Integer, List<Integer>> connectedMap) {
        List<Integer> connectedList = connectedMap.get(targetNode);
        if (connectedList == null) {
            return new ArrayList<>();
        }
        List<Integer> filteredList = connectedList.stream()
                .filter(x -> !visitedList.get(x - 1)) // 인덱스 수정
                .collect(Collectors.toList());

        return filteredList;
    }

    public static HashMap<Integer, List<Integer>> inputMethod(Scanner scanner) {
        nodeCount = scanner.nextInt();
        scanner.nextLine();
        int lineNumber = scanner.nextInt();
        scanner.nextLine();

        ArrayList<int[]> lines = new ArrayList<>();
        for(int i = 0; i < lineNumber; i++) {
            String tempLine = scanner.nextLine();
            String[] tempLines = tempLine.split(" ");
            int[] tempArray = Arrays.stream(tempLines)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            lines.add(tempArray);
        }

        HashMap<Integer, List<Integer>> connectedMap = new HashMap<>();
        for (int[] x : lines) {
            if (connectedMap.containsKey(x[0])) {
                connectedMap.get(x[0]).add(x[1]);
            } else {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(x[1]);
                connectedMap.put(x[0], tempList);
            }
            // 양방향 연결 추가
            if (connectedMap.containsKey(x[1])) {
                connectedMap.get(x[1]).add(x[0]);
            } else {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(x[0]);
                connectedMap.put(x[1], tempList);
            }
        }

        return connectedMap;
    }
}
