package solving.programmers.Level1;

public class 평균_구하기 {
    public double solution(int[] arr) {
        double answer = 0;
        int sum=0;
        for(int i:arr) sum+=i;
        answer = (double) sum / arr.length;
        return answer;
    }
}
