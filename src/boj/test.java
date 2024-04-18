package boj;

import java.util.ArrayList;
public class test {
    public static void main(String[] args) {

        ArrayList<Integer> testArray = new ArrayList<>();
        testArray.add(1);
        testArray.add(2);

        test(testArray);

        for(Integer x : testArray) {
            System.out.println(x);
        }

    }
    public static void test(ArrayList<Integer> targetArray) {
        ArrayList<Integer> testArray = new ArrayList<>();
        testArray.add(1);
        targetArray = testArray;
    }
}