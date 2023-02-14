package solving.baekjoon.n18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList; 

class MyQueue {
	LinkedList<Integer> arr  = new LinkedList<Integer>();

	void push(int x) {
		arr.add(x);
	}
	
	int pop() {
		if(!arr.isEmpty()) {
			return arr.remove(0);
		}
		return -1;
	}
	
	int size() {
		return arr.size();
	}
	
	int empty() {
		if(arr.isEmpty()) return 1;
		else return 0;
	}
	
	int front() {
		if(!arr.isEmpty()) {
			return arr.get(0);
		}
		return -1;
	}
	
	int back() {
		if(!arr.isEmpty()) {
			return arr.get(arr.size()-1);
		}
		return -1;
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		MyQueue queue = new MyQueue();
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			 String[] command = br.readLine().split(" ");
			switch (command[0]) {
			case "push":
				queue.push(Integer.parseInt(command[1]));
				break;
			case "pop":
				sb.append(queue.pop()+"\n");
				break;
			case "size":
				sb.append(queue.size()+"\n");
				break;
			case "empty":
				sb.append(queue.empty()+"\n");
				break;
			case "front":
				sb.append(queue.front()+"\n");
				break;
			case "back":
				sb.append(queue.back()+"\n");
				break;
			}
		}
		System.out.println(sb);

	}

}
