import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * N*N 표 수가 채워져있음
 * 모든 수는 자신의 한칸 위보다 큼
 * */

public class Main {
	static class Number implements Comparable<Number> {
		int num;

		public Number(int num) {
			super();
			this.num = num;
		}
		
		

		@Override
		public String toString() {
			return Integer.toString(num);
		}

		@Override
		public int compareTo(Number o) {
			return o.num - this.num;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Number> pq = new PriorityQueue<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.add(new Number(num));
			}
		}
		
		for(int i=1; i<=N-1; i++) pq.poll();
		System.out.println(pq.poll());
	}
}