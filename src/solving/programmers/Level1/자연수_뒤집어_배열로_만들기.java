package solving.programmers.Level1;

public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];
        for(int i=0; i<answer.length; i++) {
            answer[i] =str.charAt(answer.length-1-i)-'0';
        }
        return answer;
    }
}
