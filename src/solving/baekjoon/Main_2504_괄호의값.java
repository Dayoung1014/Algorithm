package solving.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_2504_괄호의값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		char last=' '; //최근에 완료된 괄호 set이 뭔지
		int lastNum = 0;  //최근에 완료된 괄호 set 합계
		
		for(int i=0; i<input.length(); i++) {
			char now = input.charAt(i);
			
			if(now=='(') stack.add('(');
			else if(now=='[') stack.add('[');
			else {
				if(stack.isEmpty()) {
					System.out.println(0);
					break;
				}
				else {
					char out = stack.pop();
					if(out==')')  {
						if(last==' ') {
							lastNum = 2;
						}
						else if(last==']') {
							
						}
					}
					else if(out==']') {
						
					}
				}
			}
			
			
		}
	}

}
