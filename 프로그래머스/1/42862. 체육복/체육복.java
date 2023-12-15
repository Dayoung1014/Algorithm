import java.util.*;

class Solution {    
    public int solution(int n, int[] lost, int[] reserve) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=1; i<=n; i++) map.put(i, 1);
        for(int l : lost) map.put(l, map.get(l)-1);
        for(int r : reserve) map.put(r, map.get(r)+1);
        
        int answer=0;
        for(int i=1; i<=n; i++) {
            if(map.get(i)>=1) answer++;
            else if(map.get(i)==0) {
                if(i-1>=1 && map.get(i-1)==2) {
                    answer++;
                    map.put(i-1, map.get(i-1)-1);
                }
                else if(i+1<=n && map.get(i+1)==2) {
                    answer++;
                    map.put(i+1, map.get(i+1)-1);
                }
            }
        }
        return answer;
    }
}