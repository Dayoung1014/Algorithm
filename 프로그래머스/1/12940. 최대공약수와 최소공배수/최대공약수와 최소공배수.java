import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int small, big;
        if(n<m) {
            small = n;
            big = m;
        }
        else {
            small = m;
            big = n;
        }
        
        ArrayList<Integer> arr = new ArrayList();
        for(int i=1; i<=big; i++) {
            if(big%i==0) arr.add(i);
        }
        
        for(int i=arr.size()-1; i>=0; i--) {
            if(small % arr.get(i) == 0) {
                answer[0] = arr.get(i);
                break;
            }
        }
        
        //최대공약수 
        int multi = 1;
        while(true) {
            if((big*multi) % small == 0) {
                answer[1] = big*multi;
                break;
            }
            multi++;
        }
        
        // 최대공약수, 최소공배수 반환
        return answer;
    }
}