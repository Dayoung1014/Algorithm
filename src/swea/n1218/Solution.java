package swea.n1218;


/*
 *  '()', '[]', '{}', '<>' 로 이루어진 문자열
 *  
 *  */
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		nextCase:
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt(); //테스트케이스 길이
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			System.out.print("#"+test_case+" ");
			for(int i=0 ; i<str.length(); i++) {
				char now = str.charAt(i);
				//시작하는거면 스택에 넣고
				if(now=='(' | now=='[' | now=='{' | now=='<') {
					stack.add(now);
				}
				else { //끝나는거 나오면 비어있거나 pop 해서 지금꺼랑 페어가 아니라면 0 반환
					if(stack.isEmpty()) {
						System.out.println(0);
						continue nextCase;
					}
					else {
						char top = stack.pop();
						if(now == ')' && top !='(') {
							System.out.println(0);
							continue nextCase;
						}
						else if (now == ']' && top !='[') {
							System.out.println(0);
							continue nextCase;
						}
						else if (now == '}' && top !='{') {
							System.out.println(0);
							continue nextCase;
						}
						else if (now == '>' && top !='<') {
							System.out.println(0);
							continue nextCase;
						}
					}
				}
			}
			System.out.println(1);
		}
	}
}