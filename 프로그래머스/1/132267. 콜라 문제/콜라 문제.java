class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int cola = n; //현재 콜라 보유량
        int div = 0;
        int rem = 0;
        
        while(cola>=a) {
            div = cola/a*b; 
            rem = cola%a;  
            answer += div; 
            cola = div+rem;  
        }
        return answer;
    }
}