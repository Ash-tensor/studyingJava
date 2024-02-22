package boj;
//import java.util.*;
//import java.util.stream.Collectors;
//
//
//public class boj10448 {
//    public static void main(String[] args) {
//        HashMap<Integer,Integer> triangleMap = new HashMap<>();
//        triangleMap.put(1,1);
//        triangleNumber(triangleMap, 50);
//        Scanner scanner = new Scanner(System.in);
//        int repeat = scanner.nextInt();
//        scanner.nextLine();
//
//        int[] question = new int[repeat] ;
//        for (int i = 0; i < repeat; i++) {
//            if (!(i == repeat -1)){
//                question[i] = scanner.nextInt();
//                scanner.nextLine();
//            }
//            else {
//                question[i] = scanner.nextInt();
//            }
//        }
//        int[] answer = new int[repeat];
//        int counter = 0;
//        for (int i : question){
//            answer[counter] = finalSolution(triangleMap, 3, i);
//            counter += 1;
//        }
//        for (int i = 0; i < repeat; i++) {
//            if (!(i == repeat -1)){
//                System.out.println(answer[i]);
//            }
//            else {
//                System.out.print(answer[i]);
//            }
//
//
//        }

////        for(int i = 7; i < 1001; i++) {
////            System.out.println(solution(triangleMap, 3, i));
////        }
//
//
//
//    }
//    public static int finalSolution(HashMap<Integer, Integer> triangleMap, int targetNumber, int number) {
//        if (number < 7) {
//            if (number == 3 || number == 5){
//                return 1;
//            }
//            else {
//                return 0;
//            }
//        }
//        else {
//            ArrayList<ArrayList<Integer>> answer = solution( triangleMap, targetNumber, number);
//            if (answer.isEmpty()) {
//                return 0;
//            }
//            else {
//                return 1;
//            }
//        }
//    }
//
//    public static ArrayList<ArrayList<Integer>> solution(HashMap<Integer, Integer> triangleMap, int targetNumber, int number) {
//        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
//        ArrayList<Integer> nodes = new ArrayList<>(triangleMap.values());
//        List<Integer> targetNodes = nodes.stream().filter(x -> x < number).collect(Collectors.toList());
//
//        for (int index = 0; index < targetNumber; index++) {
//            int finalIndex = index;
//            List<Integer> tempNodes = targetNodes.stream().filter(x -> targetNodes.indexOf(x) >= finalIndex).collect(Collectors.toList());
//
//            ArrayList<Integer> tempNodes1 = new ArrayList<>(tempNodes);
//
//            ArrayList<ArrayList<Integer>> tempAnswers = permutation(tempNodes1, targetNumber);
//            for (ArrayList<Integer> i : tempAnswers) {
////                answer.add(i);
//                int sum = 0;
//                for (int c : i ) {
//                    sum += c;
//                }
//                if (sum == number) {
//                    answer.add(i);
//                }
//            }
//        }
//        return answer;
//    }
//    public static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> targetNodes, int targetNumber) {
//
//        //when get input, to return permutation ArrayList of number
//        ArrayDeque<ArrayList<Integer>> openList = new ArrayDeque<>();
//        ArrayList<ArrayList<Integer>> closedList = new ArrayList<>();
//
//        ArrayList<Integer> firstNode = new ArrayList<>();
//        firstNode.add(targetNodes.get(0));
//
//        openList.addLast(firstNode);
//        // [[0]]
//
//        while (true) {
//            if (openList.isEmpty()) {
//                return closedList;
//            }
//            else {
//                ArrayList<Integer> selectedNode = openList.pollFirst();
//                if (selectedNode.size() == targetNumber) {
//                    closedList.add(selectedNode);
//                }
//                else {
//                    for(int i : targetNodes) {
//                        ArrayList<Integer> copyedSelectedNode = new ArrayList<>(selectedNode);
//                        copyedSelectedNode.add(i);
//                        openList.addLast(copyedSelectedNode);
//                    }
//                }
//            }
//        }
//    }
//
//    public static void triangleNumber(HashMap<Integer,Integer> trianleMap, int target){
//        while (true) {
//            if (trianleMap.size() == target) {
//                break;
//            }
//            else {
//                int before = trianleMap.get(trianleMap.size());
//                int temp = before + (trianleMap.size() + 1);
//                trianleMap.put(trianleMap.size() + 1, temp);
//            }
//        }
//    }
//}

import java.util.ArrayList;
import java.util.Scanner;

public class boj10448 {
    public static void main(String[] args) {
        ArrayList<Integer> triangleList = new ArrayList<>();
        for (int i = 1 ; i < 65; i ++) {
            int answer = i*(i+1)/2;
            triangleList.add(answer);
        }
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();

        int[] question = new int[repeat] ;
        for (int i = 0; i < repeat; i++) {
            if (!(i == repeat -1)){
                question[i] = scanner.nextInt();
                scanner.nextLine();
            }
            else {
                question[i] = scanner.nextInt();
            }
        }
        int[] answer = new int[repeat];
        int counter = 0;
        for (int i : question){
            answer[counter] = solution(i ,triangleList);
            counter += 1;
        }
        for (int i = 0; i < repeat; i++) {
            if (!(i == repeat -1)){
                System.out.println(answer[i]);
            }
            else {
                System.out.print(answer[i]);
            }
        }
    }
    public static int solution(int number, ArrayList<Integer> triangleList) {
        for (int i = 0; i < 60; i++) {
            for (int c = 0; c < 60; c++) {
                for (int j = 0; j < 60; j++) {
                    if (triangleList.get(i) + triangleList.get(c) + triangleList.get(j) == number) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
