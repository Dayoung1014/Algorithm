class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n>=2) answer++; 
        for(int i=3; i<=n; i++) {
                boolean prime = true;
                breakOut:
                for(int j=2; j<=Math.round(Math.sqrt(i)) ; j++) {
                    if(i%j==0) {
                        prime = false;
                        break breakOut;
                    }
                }
                if(prime) {
                    answer++;;
                }
            }
        return answer;
    }
}