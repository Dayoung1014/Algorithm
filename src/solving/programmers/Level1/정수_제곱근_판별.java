package solving.programmers.Level1;

public class 정수_제곱근_판별 {
    public long solution(long n) {
        long answer = 0;
        double s = Math.sqrt((double)n);
        if(s%1==0) return (long) Math.pow(s+1, 2);
        else return -1;
    }
}
