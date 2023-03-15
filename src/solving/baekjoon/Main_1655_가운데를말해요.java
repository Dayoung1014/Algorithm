package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


/*
 * 왼쪽 큐, 오른쪽 큐
 * 
 * 맨 처음에는 왼쪽에 넣기
 * 
 * left.peek < right.peek 이 유지 되어야 함
 * -> 이게 바뀐다면 각각 poll 해서 바꿔 넣어주기
 * 
 * 짝수 번째 left.size == right.size 
 * 홀수번째 left.size + 1 == right.size
 * -> 중간값은 left.peek();
 * 
 * */

public class Main_1655_가운데를말해요 {	
	static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); //max heap
	static PriorityQueue<Integer> right = new PriorityQueue<>(); //min heap
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int n = 1; n <= N; n++) {
			int input = Integer.parseInt(br.readLine());
			
			//큐에 넣기
			if(n%2==0) right.add(input);
			else left.add(input);

			// left.peek < right.peek 이 아니라면 각각 poll 해서 바꿔 넣어주기
			if(left.size()!=0 && right.size()!=0 && left.peek()>right.peek()) change();
			
			//중간값 말하기
			sb.append(left.peek()+"\n");
			//System.out.println(left.peek());
			//System.out.println(left.toString());
			//System.out.println(right.toString());
		}
		System.out.println(sb);
	}
	
	static void change() {
		right.add(left.poll());
		left.add(right.poll()); 
	}

}
