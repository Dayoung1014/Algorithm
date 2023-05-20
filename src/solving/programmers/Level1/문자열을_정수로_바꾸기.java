package solving.programmers.Level1;

public class 문자열을_정수로_바꾸기 {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split("\\- | \\+");
        answer = Integer.parseInt(str[str.length-1]);
        return answer;
    }
}
