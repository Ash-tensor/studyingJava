package boj;

import java.util.*;

public class MountainBridge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] heights = new int[n];
        
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        
        System.out.println(countBridges(heights));
    }
    
    public static int countBridges(int[] heights) {
        int n = heights.length;
        Map<Integer, List<Integer>> heightIndices = new HashMap<>();
        
        // 높이별 인덱스 저장
        for (int i = 0; i < n; i++) {
            if (!heightIndices.containsKey(heights[i])) {
                heightIndices.put(heights[i], new ArrayList<>());
            }
            heightIndices.get(heights[i]).add(i);
        }
        
        int count = 0;
        
        // 같은 높이를 가진 인덱스 쌍 찾기
        for (List<Integer> indices : heightIndices.values()) {
            int size = indices.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int start = indices.get(i);
                    int end = indices.get(j);
                    boolean canBuild = true;
                    
                    // 두 인덱스 사이의 높이 검사
                    for (int k = start + 1; k < end; k++) {
                        if (heights[k] >= heights[start]) {
                            canBuild = false;
                            break;
                        }
                    }
                    
                    if (canBuild) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}