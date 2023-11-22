import java.util.*;

class Solution {
    public int solution(int[] d, int budget) { 
        Arrays.sort(d);
        //System.out.println(Arrays.toString(d));
        
        int cnt = 0;
        int now = budget;
        for(int n : d) {
            if(now-n >= 0) {
                now -= n;
                cnt++;
            }
        }
        return cnt;
    }
}