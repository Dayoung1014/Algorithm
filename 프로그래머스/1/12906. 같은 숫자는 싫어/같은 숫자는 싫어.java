import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
        	if(list.get(list.size()-1) != arr[i]) {
        		list.add(arr[i]);
        	}
        }
        
        return list;
    }
}