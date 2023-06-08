package solving.programmers.Level1;

public class 자릿수_더하기 {
    public int solution(int n) {
        String str = Integer.toString(n);
        int result = 0;
        for(int i=0; i<str.length(); i++) {
            result += str.charAt(i)-'0';
        }

        return result;
    }
}
