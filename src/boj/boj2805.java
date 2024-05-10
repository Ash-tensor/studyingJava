package boj;

import java.util.*;
import java.util.stream.Collectors;

public class boj2805 {
    static List<Integer> conditions;
    static List<Integer> heights;

    // 나무 자르기 문제
    public static void main(String[] args) {
//        나무를 필요한 만큼만 집으로 가져가려고 한다. 이때,
//        적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의
//        최댓값을 구하는 프로그램을 작성하시오.

//        높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.

        Scanner scanner = new Scanner(System.in);
        inputMethod(scanner);
//        System.out.printf("%d %d\n", conditions.get(0), conditions.get(1));
//        for (Integer x : heights) {
//            System.out.println(x);
//    }

        // 첫번째 전략. 가장 짧은 나무로 자른 다음, 더 자를지 더 작게 자를지 결정해보자.
        // 시간초과로 실패
        Optional<Integer> min = heights.stream().min(Comparator.comparingInt(heights -> heights));
        Optional<Integer> max = heights.stream().max(Comparator.comparingInt(heights -> heights));

//        int answer = newSollution(min.get(), max.get(), conditions.get(1));

        int answer = finalAnswer();
        System.out.println(answer);
    }
    public static int finalAnswer() {
        int min = 0;
        Optional<Integer> max = heights.stream().max(Comparator.comparingInt(heights -> heights));
        int max1 = max.get();

        int mid = (min + max1) / 2;
        int answer = 0;
        while (min <= max1) {
            if (cuttingWood(mid) >= conditions.get(1)) {
                answer = mid;
                min = mid + 1;
            }
            else {
                max1 = mid - 1;
            }

            mid = (min + max1) / 2;

        }
        return answer;
    }

    public static int newSollution(int min, int max, int targetHeight) {
        // 이분탐색을 적용해야함
        // 어떻게 적용하느냐?
        // 가장 높은 나무와 가장 낮은 나무의 중간에서 시작해서
        // 더 위로 가야하는지, 아래로 가야하는지 선택.
        // 그리고 위로 간다면 그 위에서 다시 이분탐색을 사작

        int point = (min + max) / 2;
        int targetSum = cuttingWood(point);

        int flag = goUpOrDown(targetSum);

        if (flag == 0) {
            return point;
        }
        else if (flag == 1) {
            return newSollution(point, max, targetHeight);
        }
        else {
            return newSollution(min, point, targetHeight);
        }
    }
    public static int goUpOrDown(int targetSum) {
        if (targetSum > conditions.get(1)) {
            return 1;
        }
        else if(targetSum == conditions.get(1)) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public static int cuttingWood(int n) {
        ArrayList<Integer> cuttedWoods = new ArrayList<>();
        for (int x : heights) {
            int temp = x - n;
            if (temp <= 0) {
                temp = 0;
            }
            cuttedWoods.add(temp);
        }
        int cuttedNumber = 0;
        for (int x : cuttedWoods) {
            cuttedNumber += x;
        }

        return cuttedNumber;
    }



    public static void inputMethod(Scanner scanner) {
        String condition = scanner.nextLine();
        String height = scanner.nextLine();

        String[] conditions = condition.split(" ");
        String[] heights = height.split(" ");

        List<Integer> conditionsInt =  Arrays.stream(conditions).
                map(Integer::parseInt).collect(Collectors.toList());

        boj2805.heights = Arrays.stream(heights).map(Integer::parseInt).
                collect(Collectors.toList());
        boj2805.conditions = conditionsInt;

    }
}
