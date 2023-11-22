// 3개 합이 0이 되는 조합의 수 구하기
import java.util.*;
class Solution {
    static int answer = 0;
    void combi(int[] num, int[] sel, int count, int idx) {
        if(count == sel.length) {
            int sum = 0;
            for(int s : sel) {
                sum += s; 
            }
            if(sum == 0) answer++; 
            return;
        }
        
        for(int i=idx; i<num.length; i++) {
            sel[count] = num[i];
            combi(num, sel, count+1, i+1);
        }
    }
    
    public int solution(int[] number) {
        combi(number, new int[3], 0, 0);
        return answer;
    }
}