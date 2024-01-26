package boj;

import java.lang.reflect.Array;
import java.util.*;

public class boj2178 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mapX = scanner.nextInt();
        scanner.nextLine();
        int mapY = scanner.nextInt();
        scanner.nextLine();

        int[] tempStartNode = {0,0};
        int[] goal = {mapX-1, mapY-1};

        ArrayList<int[]> startNode = new ArrayList<>();
        startNode.add(tempStartNode);

        ArrayList<String> tempMap = new ArrayList<>();

        for(int i=0; i < mapX; i++) {
            String rowString = scanner.nextLine();
            tempMap.add(rowString);
        }

        int[][]theMap = mapper(tempMap);
        int answer = bfs_to_goal(theMap, startNode, goal);
        System.out.println(answer);
    }

    public static int[][] mapper(ArrayList<String> theMap) {
        int[][] answer = new int[theMap.size()][theMap.get(0).length()];
        int lowNum = 0;
        for(String string : theMap) {
            int yNum = 0;
            char[] temp = string.toCharArray();
            for(char i : temp) {
                answer[lowNum][yNum] = Integer.parseInt(Character.toString(i)); // << 와 실화냐
                yNum++;
            }
            lowNum++;
        }
        return answer;
    }

    public static int bfs_to_goal(int[][] the_map, ArrayList<int[]> startNode, int[] goal) {
        ArrayDeque< ArrayList<int[]> > openList = new ArrayDeque<>();
//        이게 안된다고?
//        boolean[the_map.length][the_map[0].length] visitedNode = false;
//        방문 노드 배열 생성
        boolean[][] visitedNode = new boolean[the_map.length][the_map[0].length];
        for(int i=0; i < the_map.length; i ++) {
            for (int c=0; c < the_map[0].length; c++) {
                visitedNode[i][c] = false;
            }
        }
        openList.add(startNode);
        visitedNode[startNode.get(0)[0]][startNode.get(0)[1]] = true;

        // while(openList) <- 이거안됨
        while(!openList.isEmpty()) {
            ArrayList<int[]> selectedNode = openList.getFirst(); // < popleft
            int[] lastSelectedNode = selectedNode.get(-1);

            if(lastSelectedNode.equals(goal)) {
                return selectedNode.size();
            }

            ArrayList<int[]> connectedNodeList =
                    connectedNodeChecker(the_map, lastSelectedNode[0], lastSelectedNode[1]);

            for(int[] node : connectedNodeList ) {
                if(!visitedNode[node[0]][node[1]]){
                    // 방문안했으면
//                    ArrayList<int[]> clonedSelectedNode = selectedNode.clone();
//                    와 clone도 얕은 복사야? 끔찍하네 진짜
                    ArrayList<int[]> clonedSelectedNode = new ArrayList<>(selectedNode);
                    clonedSelectedNode.add(node);
                    openList.addLast(clonedSelectedNode);
                    visitedNode[node[0]][node[1]] = true;
                }
            }
        }
        return -1;
    }

    public static ArrayList<int[]> connectedNodeChecker(int[][] the_map, int x, int y) {
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        ArrayList<int[]> valuedConnectedNode = new ArrayList<>();
        for (int i : dx) {
            int nx = x + i;
            int ny = y + i;

            if(0 <= nx && nx < the_map.length) {
                if (0 <= ny && ny < the_map[0].length) {
                    if (the_map[nx][ny] == 1) {
                        int[] temp = {nx, ny};
                        valuedConnectedNode.add(temp);
                    }
                }
            }
        }
        return valuedConnectedNode;
    }
}
