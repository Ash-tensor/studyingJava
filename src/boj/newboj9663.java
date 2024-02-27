package boj;

import java.io.*;
import java.util.*;

public class newboj9663 {
    static int N;
    static boolean[][] map;
    static int finalAnswer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new boolean[N][N];

        ArrayList<int[]> firstDepth = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            firstDepth.add(new int[]{0, i});
        }

        for (int[] temp : firstDepth) {
            dfs(temp[0], temp[1], 1, new ArrayList<int[]>());
        }

        System.out.println(finalAnswer);
    }

    public static void dfs(int x, int y, int depth, ArrayList<int[]> queenList) {
        ArrayList<int[]> dfsQueenList = new ArrayList<>(queenList);

        if (depth == N) {
            finalAnswer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (possible(x, i, dfsQueenList)) {
                dfsQueenList.add(new int[]{x, i});
                dfs(x+1, i, depth+1, dfsQueenList);
            }
        }
    }

    public static boolean possible(int x, int y, ArrayList<int[]> queenList) {
        for (int[] queen : queenList) {
            // 퀸과 같은 행 또는 열에 존재하는지 검사
            if (queen[0] == x || queen[1] == y) {
                return false;
            }
            // 대각선에 존재하는지 검사
            else if (Math.abs(queen[0] - x) == Math.abs(queen[1] - y)) {
                return false;
            }
        }
        return true;
    }
}
//    static int N;
//    static int[] arr;
//    static int count = 0;
//
//    public static void main(String[] args) throws Exception {
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        N = Integer.parseInt(st.nextToken());
//        arr = new int[N];
//
//        dfs(0);
//        System.out.println(count);
//
//        br.close();
//    }
//
//    public static void dfs(int depth) {
//        if (depth == N) {
//            //depth가 N까지 도착하면 return
//            count++;
//            return;
//        }
//        for (int i = 0; i < N; i++) {
//            arr[depth] = i;
//            if (possible(depth)) {
//                // 모든 조건에 통과하면 다음 depth탐색
//                dfs(depth + 1);
//            }
//        }
//    }
//
//    public static boolean possible(int col) {
//        for (int i = 0; i < col; i++) {
//            // 같은 행인지
//            if (arr[i] == arr[col]) {
//                return false;
//            }
//            //대각선방향에 존재하는지
//            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
//                return false;
//            }
//        }
//        // 같은행에도 없고 대각선방향에도 없으면 true
//        return true;
//    }
//}