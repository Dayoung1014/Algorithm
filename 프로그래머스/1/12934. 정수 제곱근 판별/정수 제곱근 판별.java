import java.lang.Math;

class Solution {
    public long solution(long n) {
        long answer = 0;
        double s = Math.sqrt((double)n);
        if(s%1==0) return (long) Math.pow(s+1, 2);
        else return -1; 
    }
}