package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요_시간초과 {	
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int n = 1; n <= N; n++) {
			int input = Integer.parseInt(br.readLine());
			pq.add(input);
			speak(n);
		}
		System.out.println(sb);
	}
	
	static void speak(int n) {
		int order;
		if(n%2!=0) order = n/2+1;
		else order = n/2;

		ArrayList<Integer> tmp = new ArrayList<>();
		for (int o = 0; o < order; o++) {
			tmp.add(pq.poll());
		}
		sb.append(tmp.get(tmp.size()-1)+"\n");
		for (int o = 0; o < order; o++) {
			pq.add(tmp.get(o));
		}
	}

}
