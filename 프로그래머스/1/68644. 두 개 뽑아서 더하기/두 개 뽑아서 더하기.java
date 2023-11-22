import java.util.*;

class Solution {
    public int[] solution(int[] numbers) { 
        HashSet<Integer> set = new HashSet();
        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) { 
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
    	int i=0; 
        for(int s:set){
          answer[i++] = s;
        } 
        Arrays.sort(answer);
        
        return answer;
    }
}