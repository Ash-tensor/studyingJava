package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj1449 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[] condition = new float[2];
        condition[0] = scanner.nextFloat();
        condition[1] = scanner.nextFloat();
        float[] question = new float[(int) condition[0]];

        for(int i = 0; i < condition[0]; i++) {
            question[i] = scanner.nextFloat();
        }
        Arrays.sort(question);
        int a = solve(question, condition[1]);
        System.out.println(a);

    }
    public static int solve(float[] question, float tapeLength) {
        int answer = 0;
        float tapeStart = 0;
        float tapeEnd = 0;

        for(float i : question) {
            if(tapeStart + 0.5 <= i && i <= tapeEnd - 0.5){
            }
            else {
                tapeStart = (float) (i - 0.5);
                tapeEnd = i + tapeLength;
                answer += 1;
            }
        }
        return answer;
    }
}
