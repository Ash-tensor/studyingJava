package tmemorysample;

import java.util.List;

public class SolveB {
    public int add(List<Integer> a){
        int answer = 0;
        for(int i = 0; i < a.size(); i++) {
            answer += a.get(i);
        }
        return answer;
    }
}
