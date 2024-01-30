package boj;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//conference_number = int(input())
//conference_list = []
//        for _ in range(conference_number) :
//start, end = map(int, input().split())
//        conference_list.append((start, end))
//
//conference_list.sort(key=lambda x: (x[1], x[0]))
//
//n = 0
//answer = 0
//
//        for c, i in conference_list :
//        if n <= c :
//answer += 1
//n = i
//
//print(answer)
public class boj1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int conferenceNumber = scanner.nextInt();

        ArrayList<int[]> conferenceList = new ArrayList<>();

        for(int i = 0; i < conferenceNumber; i++) {
            int[] temp = new int[2];
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            temp[0] = start;
            temp[1] = end;
            conferenceList.add(temp);
        }

        Collections.sort(conferenceList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        } );
        int n = 0;
        int answer = 0;

        for(int i = 0; i < conferenceList.size(); i++) {
            if (n <= conferenceList.get(i)[0]) {
                answer += 1;
                n = conferenceList.get(i)[1];
            }
        }
        System.out.println(answer);
    }
}
