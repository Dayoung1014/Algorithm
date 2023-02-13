package solving.programmers.n42584;


class Solution { //가격이 떨어지지 않은 기간이 몇 초인지
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {1, 2, 3, 2, 3}));
		
	}
    public int[] solution(int[] prices) { //초 단위로 기록된 주식 가격
        int[] answer = new int[prices.length]; // 떨어지지 않은 기간
        
        for(int i=0; i<prices.length; i++) {
        	int cnt = 0;
        	for(int j=i+1; j<prices.length; j++) {
        		if(prices[i] <= prices[j]) {
        			cnt++;
        		}
        		else {
        			if(j==i+1) {
        				cnt=1;
        			}
        			break;
        		}
        	}
        	answer[i] = cnt;
        }
        
        for(int i:answer) System.out.println(i);
        return answer;
    }
}