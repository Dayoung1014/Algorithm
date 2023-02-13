package solving.programmers.n12909;

import java.util.Stack;

// 시작 괄호 ( stack 에 넣어줌
// 끝 괄호 ) 만날 때 마다 stack.pop
// pop 할게 없으면 false
// 끝났는데 stack 남아있으면 false

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == '(') { // 시작 괄호 만나면 
        		stack.add('('); //stack에 넣어줌
        	}
        	else { // 끝 괄호 만났는데
        		if(stack.isEmpty()) { // 스택이 비어있으면 = ( 짝이 없음
        			answer = false;
        			break;
        		}
        		else {
        			stack.pop();
        		}
        		
        	}
        }
        
        // 다 봤는데 stack에 남아있으면 false
        if(!stack.isEmpty()) {
        	answer = false;
        }
  
        return answer;
    }
}