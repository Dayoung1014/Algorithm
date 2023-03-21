package solving.programmers;
import java.util.*;

// ArrayList로 풀기
//public class Solution {
//    public ArrayList<Integer> solution(int []arr) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(arr[0]);
//        for(int i=1; i<arr.length; i++) {
//        	if(list.get(list.size()-1) != arr[i]) {
//        		list.add(arr[i]);
//        	}
//        }
//        
//        return list;
//    }
//}

// Stack으로 풀기
public class Solution_12906 {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
        	if(stack.peek() != arr[i]) {
        		stack.add(arr[i]);
        	}
        }
        
        return stack;
    }
}