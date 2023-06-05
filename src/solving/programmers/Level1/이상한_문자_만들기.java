package solving.programmers.Level1;

public class 이상한_문자_만들기 {
    public String solution(String s) {
        String answer = "";

        int idx = 0;
        for(int i=0; i<s.length(); i++) {
            char now = s.charAt(i);
            if(now==' ') {
                idx = 0;
            }
            else {
                if(idx % 2 == 0) now = Character.toUpperCase(now);
                else now = Character.toLowerCase(now);
                idx++;
            }
            answer += now;
        }
        return answer;
    }
}
