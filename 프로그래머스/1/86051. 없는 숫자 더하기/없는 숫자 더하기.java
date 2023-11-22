class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] b = new boolean[10];
        for(int n : numbers) {
            b[n] = true;
        }
        for(int i=0; i<b.length; i++) {
            if(!b[i]) answer+=i;
        }
        return answer;
    }
}