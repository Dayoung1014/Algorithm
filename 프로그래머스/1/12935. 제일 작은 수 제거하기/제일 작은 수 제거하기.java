import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList();
        int min = Arrays.stream(arr).min().getAsInt();
        for(int a : arr) {
            if(a!=min) list.add(a);
        }
        if(list.size()==0) list.add(-1);
        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}