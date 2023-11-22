import java.util.*;

public class Solution {
    public int solution(int n) {
        String str = Integer.toString(n);
        int result = 0;
        for(int i=0; i<str.length(); i++) {
            result += str.charAt(i)-'0';
        }
        
        return result;
    }
}