package boj;

import java.lang.reflect.Array;
import java.util.*;

public class boj7785 {

    public static void main(String[] args) {
        List<String> coworkerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int coworkerNumber = scanner.nextInt();

        for(int i = 0; i < coworkerNumber; i++) {
            String coworkerName = scanner.next();
            String sign = scanner.next();
            if (sign.equals("enter")){
                coworkerList.add(coworkerName);
            }
            else {
               coworkerList.remove(coworkerName);
            }
        }

        Collections.sort(coworkerList, Collections.reverseOrder());
        for(String coworker : coworkerList) {
            System.out.println(coworker);
        }
    }
}
//package boj;
//import java.util.*;

//
//public class boj7785 {
//    public static void main(String[] args) {
//        Set<String> coworkerSet = new HashSet<>();
//
//        Scanner scanner = new Scanner(System.in);
//        int coworkerNumber = scanner.nextInt();
//
//        for (int i = 0; i < coworkerNumber; i++) {
//            String coworkerName = scanner.next();
//            String sign = scanner.next();
//
//            if (sign.equals("enter")) {
//                coworkerSet.add(coworkerName);
//            } else {
//                coworkerSet.remove(coworkerName);
//            }
//        }
//
//        List<String> coworkerList = new ArrayList<>(coworkerSet);
//        Collections.sort(coworkerList, Collections.reverseOrder());
//
//        for (String coworker : coworkerList) {
//            System.out.println(coworker);
//        }
//    }
//}
