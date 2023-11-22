import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<Character> small = new ArrayList();
        ArrayList<Character> big = new ArrayList();
        
        // 소문자 내림차순 + 대문자 내림차순
        for(int i=0; i<s.length(); i++) {
            char now = s.charAt(i);
            if(now >= 'a' && now <= 'z') small.add(now);
            else big.add(now);
        }
        
        Collections.sort(small, Collections.reverseOrder());  
        Collections.sort(big, Collections.reverseOrder());  
        
        for(char sm : small) answer+=sm;
        for(char bi : big) answer+=bi;
        
        return answer;
    }
}