package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class boj5397 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < repeat; i++) {
            String quest = scanner.nextLine();

            char[] charArray = quest.toCharArray();

            List<Character> linkedChar = new LinkedList<>();
            int counter = 0;
            for (char cha : charArray){
                switch(cha) {
                case '<':
                    if(counter > 0) counter--;
                    break;
                case '>':
                    if(counter < linkedChar.size()) counter++;
                    break;
                case '-':
                    if(counter > 0) {
                        linkedChar.remove(--counter);
                    }
                    break;
                default:
                    linkedChar.add(counter++, cha);
            }
            }
            StringBuilder SB = new StringBuilder();
            for (char c : linkedChar) {
                SB.append(c);
            }
            String answer = SB.toString();
            System.out.println(answer);
        }
    }
}
//package boj;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//
//public class boj5397 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int repeat = scanner.nextInt();
//        scanner.nextLine(); // 줄 바꿈 처리
//
//
//        for(int i = 0; i < repeat; i++) {
//            String input = scanner.nextLine();
//            solve(input);
//        }
//    }
//
//    public static void solve(String input) {
//        List<Character> list = new LinkedList<>();
//        int cursor = 0;
//        for(char c : input.toCharArray()) {
//            switch(c) {
//                case '<':
//                    if(cursor > 0) cursor--;
//                    break;
//                case '>':
//                    if(cursor < list.size()) cursor++;
//                    break;
//                case '-':
//                    if(cursor > 0) {
//                        list.remove(--cursor);
//                    }
//                    break;
//                default:
//                    list.add(cursor++, c);
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(char c : list) {
//            sb.append(c);
//        }
//        System.out.println(sb.toString());
//    }
//}
