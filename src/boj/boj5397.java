//package boj;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//
//public class boj5397 {
//    public static void main(String[] args) {
//        String quest = "<<BP<A>>Cd-";
//
//        char[] charArray = quest.toCharArray();
//        List<Character> linkedChar = new LinkedList<Character>();
//        int counter = 0;
//        for (char cha : charArray){
//            if(counter > 0 && cha == '<') {
//                counter -= 1;
//            }
//            else if(cha == '<') {}
//            else if(counter < linkedChar.size() && cha == '>') {
//                counter += 1;
//            }
//            else if(cha == '>') {}
//            else if(counter > 0 && cha == '-'){
//                linkedChar.remove(counter);
//                counter -= 1;
//            }
//            else if(cha == '-') {}
//            else {
//                linkedChar.add(counter, cha);
//                counter += 1;
//            }
//        }
//        String answer = linkedChar.toString();
//        System.out.println(answer);
//    }
//}
package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class boj5397 {
    static final int a = 5 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine(); // 줄 바꿈 처리


        for(int i = 0; i < repeat; i++) {
            String input = scanner.nextLine();
            solve(input);
        }
    }

    public static void solve(String input) {
        List<Character> list = new LinkedList<>();
        int cursor = 0;
        for(char c : input.toCharArray()) {
            switch(c) {
                case '<':
                    if(cursor > 0) cursor--;
                    break;
                case '>':
                    if(cursor < list.size()) cursor++;
                    break;
                case '-':
                    if(cursor > 0) {
                        list.remove(--cursor);
                    }
                    break;
                default:
                    list.add(cursor++, c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
