package solving.programmers.Level1;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {
    public long solution(long n) {
        long answer = 0;
        char[] arr = Long.toString(n).toCharArray();
        Arrays.sort(arr);
        String res = new StringBuilder(new String(arr)).reverse().toString();
        return Long.parseLong(res);
    }
}
