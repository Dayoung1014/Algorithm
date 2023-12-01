import java.util.*;
import java.lang.*;

class Solution {
    static int ans = 0;
    public void combi(int [] nums, int [] sel, int cnt, int idx) {
        if(cnt == sel.length) { 
            // 다 더했을 때 소수인지 확인
            int sum = 0;
            for(int i : sel) {
                sum += i;
            } 
            boolean chk = true;
            for(int i=2; i<=Math.sqrt(sum); i++) { 
                if(sum%i == 0) chk = false;
            }
            if(chk) ans++;
             
            return;
        }
        
        for(int i=idx; i<nums.length; i++) {
            sel[cnt] = nums[i];
            combi(nums, sel, cnt+1, i+1);
        }
    }
    
    public int solution(int[] nums) {  
        combi(nums, new int[3], 0, 0);
         
        return ans;
    }
}

