class Solution {
    public int solution(int[][] sizes) {
        //둘중에 큰거가 앞으로 오게
        //둘중에 작은거가 뒤로 오게
        // 앞의것 중에 큰거, 뒤에것 중에 작은거 구하기
        int answer = 0;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
 
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] > sizes[i][1]) {
                max1 = Math.max(max1, sizes[i][0]);
                max2 = Math.max(max2, sizes[i][1]);
            }
            else {
                max1 = Math.max(max1, sizes[i][1]);
                max2 = Math.max(max2, sizes[i][0]);
            }
        }
        answer = max1 * max2;
        return answer;
    }
}