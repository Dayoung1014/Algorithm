package solving.programmers.Level1;

public class 시저_암호 {
    public String solution(String s, int n) {
        String answer = "";

        for(int i=0; i<s.length(); i++) {
            char now = s.charAt(i);
            char next;
            if(now==' ') {
                next = ' ';
            }
            else {
                int diff;
                if(now >= 'a' && now<='z') {
                    diff = now-'a';
                    next = (char) ('a' + ((diff+n) % 26));
                }
                else {
                    diff = now-'A';
                    next = (char) ('A' + ((diff+n) % 26));
                }
            }

            answer += next;
        }
        return answer;
    }
}
