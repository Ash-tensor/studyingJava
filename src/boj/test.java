package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class test {
    public static String cipherString;

    public static void main(String[] args) {


    }
    public static HashMap<Character, Character> inputMethod() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cipherString = br.readLine();
        String temp = br.readLine();
        int number = Integer.parseInt(temp);

        HashMap<Character, Character> cipherMap = new HashMap<>();

        for(int i = 0; i < number; i++) {
            String tempKey = br.readLine();
            String tempValue = br.readLine();
            cipherMap.put(tempKey.charAt(0), tempValue.charAt(0));
        }

        return cipherMap;
    }

    public static String solution(HashMap<Character, Character> cipherMap) {
        StringBuilder result = new StringBuilder();
        for (char x : cipherString.toCharArray()) {
            char current = x;
            // 매칭이 더 이상 없을 때까지 반복
            while (cipherMap.containsKey(current)) {
                current = cipherMap.get(current);
            }
            result.append(current);
        }
        return result.toString();
    }
}
