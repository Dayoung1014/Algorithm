package solving.baekjoon.n9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		continueOut:
		for(int t=0; t<T; t++) {
			String str = sc.next();
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				char now = str.charAt(i);
				if(now == '(') stack.add('(');
				else {
					if(stack.isEmpty()) {
						sb.append("NO\n");
						continue continueOut;
					}
					else stack.pop();
				}
			}
			if(!stack.isEmpty()) sb.append("NO\n");
			else sb.append("YES\n");
		}
		System.out.println(sb);
	}

}
