package programmers;
class Solution {
    public int solution(int[] quest, int target) {
        int sumQuest = 0;

        for(int i : quest) {
            sumQuest = sumQuest + i;
        }

        int subsetSum = (sumQuest + target) / 2;
        int dp[] = new int[subsetSum + 1];
        dp[0] = 1;

        for(int num : quest) {
            for(int j = subsetSum; j >= num; j--) { // j >= num으로 변경
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[subsetSum];
    }

    public static void main(String[] args) {
        int[] quest = {4,2,1,2};
        int targetNumber = 4;
        Solution sol = new Solution(); // Solution 클래스의 인스턴스 생성
        int answer = sol.solution(quest,targetNumber); // 인스턴스 메소드 호출
        System.out.println(answer);
    }
}


