package solving.programmers.Level1;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
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
