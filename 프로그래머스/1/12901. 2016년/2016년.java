class Solution {
    public String solution(int a, int b) { 
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        //1월 1일로부터 지난 날의 수
        int days = -1;
        for(int m=1; m<a; m++) {
            days += month[m];
        }
        days += b;
         
        return day[days%7];
    }
}