package solving.programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;

public class 나누어_떨어지는_숫자_배열 {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList();
        for(int a : arr) {
            if(a%divisor==0) list.add(a);
        }
        Collections.sort(list);
        if(list.size() == 0) list.add(-1);
        int[] answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}
