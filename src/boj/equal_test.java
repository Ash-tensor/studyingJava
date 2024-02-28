package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class equal_test {
    public static void main(String[] args) {
//        ArrayList<int[]> testArrayList = new ArrayList<>();
//        int[] targetIntArray = {1, 2};
//
//        testArrayList.add(targetIntArray);
//        boolean question1 = testArrayList.contains(targetIntArray);
//        System.out.println(question1);
//
//        int[] sameValueArray = {1, 2};
//
//        boolean question2 = testArrayList.contains(sameValueArray);
//        System.out.println(question2);

        ArrayList<ArrayList<Integer>> testArrayList = new ArrayList<>();

        ArrayList<Integer> targetIntArrayList = new ArrayList<>();
        targetIntArrayList.add(1);
        targetIntArrayList.add(2);

        testArrayList.add(targetIntArrayList);
        boolean question1 = testArrayList.contains(targetIntArrayList);
        System.out.println(question1);

        ArrayList<Integer> sameValueArray = new ArrayList<>();
        sameValueArray.add(1);
        sameValueArray.add(2);
        testArrayList.add(sameValueArray);

        boolean question2 = testArrayList.contains(sameValueArray);
        System.out.println(question2);



    }
}
