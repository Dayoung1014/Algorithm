import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<answer.length; i++) {
            String[] arr = photo[i];
            for(String n : arr) {
                if(map.get(n)==null) continue;
                answer[i] += map.get(n);
            }
        }
        return answer;
    }
}