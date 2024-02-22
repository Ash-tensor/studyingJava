package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class newboj1987 {
    // 상하좌우 순서로 방향배열 선언
    static int R, C;
    static int[][] theMap;
    static int[] x_way = {-1, 1, 0, 0};
    static int[] y_way = {0, 0, -1, 1};
    static int answer = 0;
    static boolean[] visited = new boolean[26];
    public static void dfs(int x, int y, int count) {
        if (R == 1 && C == 1) {
            answer = 1;
            return;
        }
        if (count >= 26) {
            answer = count;
            return;
        }
        if (visited[theMap[x][y]]) {
            answer = Math.max(answer, count);
            return;
        }
        else {
            visited[theMap[x][y]] = true;
            ArrayList<int[]> moveList =  ableMove(x,y);
            for(int[] coordinates : moveList) {
                dfs(coordinates[0], coordinates[1], count+1);
            }
        }

        visited[theMap[x][y]] = false;


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        theMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                theMap[i][j] = str.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);
        // (0,0)부터 시작하며, 현재 이동한 위치는 0회

        System.out.println(answer);

    }
    public static ArrayList<int[]> ableMove(int x, int y) {
        ArrayList<int[]> coordinates = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            int x_position = x + x_way[i];
            int y_position = y + y_way[i];

            if(x_position < 0 || x_position > theMap.length-1 || y_position < 0 || y_position > theMap[0].length-1 ){
            }
            else {
                int[] temp = {x_position, y_position};
                coordinates.add(temp);
            }
        }
        return coordinates;
    }
}