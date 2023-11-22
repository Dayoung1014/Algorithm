class Solution {
    public int[] solution(String s) {
       
        int len = s.length();
         int[] answer = new int[len];
        int[] alpha = new int['z'-'a'+1]; 
 
        for(int i=0; i<alpha.length; i++) {
            alpha[i] = -1;
        }
        
        for(int i=0; i<s.length(); i++) {
            char now = s.charAt(i);
            // 처음 나옴
            if(alpha[now-'a']==-1) answer[i] = -1;
            
            // 나온적 있는 경우
            else answer[i] = i-alpha[now-'a'];
            
            // 알파벳의 최근 인덱스 갱신
            alpha[now-'a'] = i; 
        }
        
        return answer;
    }
}