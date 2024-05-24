package boj;
import java.util.*;
import java.util.stream.Collectors;

public class boj2805new {
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
        System.out.println(solution());
    }

    public static long recursiveSolution(long max, long min, long requiringWoods) {
        long mid = (max + min) / 2;
        long cuttedWoods = cuttingWood(mid);

        if (max - min == 1) {
            return mid;
        }
        if (cuttedWoods == requiringWoods) {
            return mid;
        }

        else if (cuttedWoods > requiringWoods) {
            // 필요한 나무보다 자른 나무가 더 많으면 나무를 줄여야됨
            // 그러니까 기준점을 위로 올려야함

            return recursiveSolution(max, mid, requiringWoods);
        }
        else {
            return recursiveSolution(mid, min, requiringWoods);
        }
    }


    public static long solution() {
        long max = heights.stream().max(Comparator.comparingInt(heights -> heights)).get();
        long min = 0;
        int requiringWoods = conditions.get(1);
        long mid = (max + min) / 2;
        long answer = 0;

        // 중간으로 자른다.
        while (max - min > 1) {
            long cuttedWoods =  cuttingWood(mid);

            // 위로 가거나 중간이거나 아래로 가거나 움직일 수 없으면 리턴.
            // 1: 같으면 리턴
            if (cuttedWoods == requiringWoods) {
                return mid;
            }
            else if(cuttedWoods > requiringWoods) {
                // 많으면 줄여야 되니까 줄이는 기준선을 위로 올려야 함
                min = mid;
            }
            else if(cuttedWoods < requiringWoods) {
                //적으면 늘려야 하니까 기준선을 아래로 내려야 함
                max = mid;
            }
            mid = (min + max) / 2;
        }
        return (max + min) / 2;
    }



    public static long cuttingWood(long n) {
        ArrayList<Long> cuttedWoods = new ArrayList<>();
        for (long x : heights) {
            long temp = x - n;
            if (temp <= 0) {
                temp = 0;
            }
            cuttedWoods.add(temp);
        }
        long cuttedNumber = 0;
        for (Long x : cuttedWoods) {
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

        boj2805new.heights = Arrays.stream(heights).map(Integer::parseInt).
                collect(Collectors.toList());
        boj2805new.conditions = conditionsInt;
    }
}
