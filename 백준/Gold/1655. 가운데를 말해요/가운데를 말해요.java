import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {	
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
		}
		System.out.println(sb);
	}
	
	static void change() {
		right.add(left.poll());
		left.add(right.poll()); 
	}

}