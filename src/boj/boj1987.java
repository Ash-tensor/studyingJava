package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1987 {

    static int R, C;
    static int[][] map;
    static boolean[] visit = new boolean[26];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int ans = 0;

    public static void dfs(int x, int y, int count) {
        if (visit[map[x][y]]) { // 0,0에 저장된 알파벳이 이미 한번 방문한 알파벳이라면,
            ans = Math.max(ans, count); // 정답을 갱신해준다.
            return; // 조건에 만족하므로 리턴.
        } else {
            visit[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
                    dfs(cx, cy, count + 1);
                }

            }

            visit[map[x][y]] = false;

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);
        // (0,0)부터 시작하며, 현재 이동한 위치는 0회

        System.out.println(ans);
    }
}

//public class boj1987 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] condition = new int[2];
//
//        condition[0] = scanner.nextInt();
//        condition[1] = scanner.nextInt();
//        scanner.nextLine();
//
//        char[][] theMap = new char[condition[0]][condition[1]];
//
//        for (int i = 0; i < condition[0]; i++) {
//            int counter = 0;
//            String string = scanner.nextLine();
//            char[] chars = string.toCharArray();
//            for (char c : chars) {
//                theMap[i][counter] = c;
//                counter += 1;
//            }
//        }
//        ArrayDeque<ArrayList<int[]>> answer = dfs(theMap) ;
//
//        for(ArrayList<int[]> i : answer) {
//            i.stream().forEach(x -> System.out.printf("[%d, %d]", x[0], x[1]));
//            System.out.println();
//
//        }
//
//        List<Integer> maxList = new ArrayList<Integer>();
//        for(ArrayList<int[]> i : answer) {
//            maxList.add(i.size());
//        }
//
//        Optional<Integer> max = maxList.stream().max(Integer::compareTo);
//        max.ifPresent(System.out::println);
//    }
//
//    public static ArrayDeque<ArrayList<int[]>> dfs(char[][] theMap) {
//        int[] startNode = {0, 0};
//        int maxLen = 0;
//        int[] endNode = {theMap.length-1, theMap[0].length-1};
//
//        ArrayDeque<ArrayList<int[]>> openList = new ArrayDeque<>();
//        ArrayDeque<ArrayList<int[]>> closedList = new ArrayDeque<>();
//
//        ArrayList<int[]> tempStartNode = new ArrayList<>();
//        tempStartNode.add(startNode);
//        openList.add(tempStartNode);
//        ArrayList<int[]> selectedNode = new ArrayList<>();
//
//        while(true) {
//            //함수종료조건 openList가 비어있을때
//            if (openList.isEmpty()) {
//                return closedList;
//            }
//            //제대로 추출했고
//            selectedNode = openList.pollFirst();
//            int[] lastSelectedNode = selectedNode.get(selectedNode.size()-1);
//            ArrayList<int[]> connectedList = connectedNode(theMap, lastSelectedNode);
//            ArrayList<int[]> ableToMoveList = alphabeticalChecker(theMap, selectedNode, connectedList);
////            ableToMoveList << 여기에서
//
//            if (ableToMoveList.isEmpty()) {
//                //만약 path(selectedNode)가 최종적으로 움직일 수 있는 곳이면
//                if(selectedNode.size() > maxLen) {
//                    closedList.add(selectedNode);
//                    maxLen = selectedNode.size();
//                }
//            }
//            else {
//                for (int[] i : ableToMoveList){
//                    ArrayList<int[]> copyedSelectedNode = new ArrayList<>(selectedNode);
//                    copyedSelectedNode.add(i);
//                    openList.add(copyedSelectedNode);
//                }
//            }
//        }
//    }
//    public static ArrayList<int[]> alphabeticalChecker(char[][] theMap, ArrayList<int[]> selectedNode, ArrayList<int[]> connectedNode) {
//        // 일단 시간을 위해서 이미 방문한 알파벳 체크를 위한 HashSet 선언
//        HashSet<Character> visitedAlphabet = new HashSet<>();
//        char[] visitedNode = new char[26];
//
//        ArrayList<int[]> canMove = new ArrayList<>();
//        // connectedNode에서 지나온 경로(selectedNode 에 있는 int[]들)은 제거해줘야함
//        for (int[] i : selectedNode) {
//            visitedAlphabet.add(theMap[i[0]][i[1]]);
//        }
//        for (int[] i : connectedNode) {
//            if (visitedAlphabet.contains(theMap[i[0]][i[1]])) {
//            }
//            else {
//                if (selectedNode.contains(i)) {
//                    // 이미 지나온 길이면 pass
//                }
//                else {
//                    //이미 지나오지 않은 길들만 add
//                    canMove.add(i);
//                }
//            }
//        }
//        return canMove;
//    }
//    public static ArrayList<int[]> connectedNode(char[][] theMap, int[] position) {
//        ArrayList<int[]> answer = new ArrayList<>();
//
//        //상하좌우 방향배열 선언
//        int[] dx = {-1, 1, 0, 0};
//        int[] dy = {0, 0, -1, 1};
//
//        for(int i = 0; i < 4; i++) {
//            int[] tempPosition = {position[0] + dx[i], position[1] + dy[i]};
//            if (tempPosition[0] < 0 || tempPosition[0] > theMap.length-1 || tempPosition[1] < 0 || tempPosition[1] > theMap[0].length-1) {
//            // 이것 중에 하나라도 모두 true면 이동할 노드가 될 수 없음(맵의 테두리를 벗어나는 판정)
//            }
//            else {
//                //  지나온 길은 선택하면 안 되는데, 옳은 구조는 아니지만 아무튼 dfs 함수에서 구현
//                answer.add(tempPosition);
//            }
//        }
//        return answer;
//    }
//}
//


