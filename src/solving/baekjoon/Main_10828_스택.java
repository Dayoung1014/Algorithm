package solving.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

class MyStack{
	ArrayList<Integer> stack = new ArrayList<>();
	
	void push(int x) {
		stack.add(x);
	}
	
	int pop() {
		if(stack.isEmpty()) {
			return -1;
		}
		else {
			int popNum = stack.get(stack.size()-1); 
			stack.remove(stack.size()-1);
			return popNum;
		}
	}
	
	int size() {
		return stack.size();
	}
	 
	int empty() {
		if(stack.isEmpty()) return 1;
		else return 0;
	}
	
	int top() {
		if(stack.isEmpty()) return -1;
		else return stack.get(stack.size()-1);
	}
}

public class Main_10828_스택 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		MyStack stack = new MyStack();
		for(int i=0; i<N; i++) {
			String order = sc.next();
			switch (order) {
			case "push":
				int n = sc.nextInt();
				stack.push(n);
				break;
			case "pop":
				sb.append(stack.pop()+"\n");
				break;
			case "size":
				sb.append(stack.size()+"\n");
				break;
			case "empty":
				sb.append(stack.empty()+"\n");
				break;
			case "top":
				sb.append(stack.top()+"\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
