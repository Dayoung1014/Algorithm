package solving.programmers.Level1;

public class 음양_더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<signs.length; i++) {
            if(signs[i]) answer+=absolutes[i];
            else answer-=absolutes[i];
        }
        return answer;
    }
}
