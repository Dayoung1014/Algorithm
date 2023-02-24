package solving.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine(); //공백 포함 입력 
		Stack<Character> stack = new Stack<>(); //단어 선입후출을 위한 stack
		boolean tagOpen = false;
		char now;
		
		for(int i=0; i<str.length();i++) {
			now = str.charAt(i);
			if(now=='<') { //태그 시작 // 지금까지의 stack pop
				tagOpen = true;
				stackPop(stack);
				System.out.print(now);
			}
			else if(now == '>'){ //태그 끝 
				tagOpen = false;
				System.out.print(now);
			}
			else if(tagOpen) { //태그 내부 
				System.out.print(now);
			}
			else if(now == ' ') { //공백 // 지금까지의 stack pop
				stackPop(stack);
				System.out.print(now);
			}
			else { // 단어의 경우 stack add
				stack.push(now);
			}			
		}
		stackPop(stack);
	}

	static void stackPop(Stack stack) {
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

}

