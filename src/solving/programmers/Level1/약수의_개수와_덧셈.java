package solving.programmers.Level1;

public class 약수의_개수와_덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++) {
            int cnt = 0;
            for(int c=1; c<=i; c++) {
                if(i%c==0) cnt++;
            }
            if(cnt%2==0) answer+=i;
            else answer -=i;
        }
        return answer;
    }
}
