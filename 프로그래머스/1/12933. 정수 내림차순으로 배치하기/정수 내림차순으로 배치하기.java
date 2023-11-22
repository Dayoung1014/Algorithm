import java.util.*;
import java.lang.StringBuilder;
class Solution {
    public long solution(long n) {
        long answer = 0; 
        char[] arr = Long.toString(n).toCharArray();
        Arrays.sort(arr);
        String res = new StringBuilder(new String(arr)).reverse().toString();
        return Long.parseLong(res);
    }
}