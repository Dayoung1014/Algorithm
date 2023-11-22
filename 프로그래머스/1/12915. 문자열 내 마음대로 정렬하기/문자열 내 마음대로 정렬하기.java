import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        // str1.compareTo(str2); 음수 : str1이 사전순 앞
        String[] plus = new String[strings.length];
        for(int i=0; i<plus.length; i++) {
            plus[i] = strings[i].charAt(n) + strings[i];
        }
        Arrays.sort(plus);
  
        for(int i=0; i<plus.length; i++) {
            answer[i] = plus[i].substring(1);
        }
        return answer;
    }
}