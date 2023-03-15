package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_13975_파일합치기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < K; k++) {
				long input = Long.parseLong(st.nextToken());
				pq.add(input);
			}
			
			long result = 0;
			while(true) {
				long a = pq.poll();
				long b = pq.poll();
				result += a+b;
				if(pq.isEmpty()) break;
				
				pq.add(a+b);
			}
			System.out.println(result);
		}
	}
}
