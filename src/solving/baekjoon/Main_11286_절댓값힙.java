package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
	static PriorityQueue<Number> pq = new PriorityQueue<>();
	
	static class Number implements Comparable<Number>{
		int num;

		
		public Number(int num) {
			super();
			this.num = num;
		}


		@Override
		public int compareTo(Number o) { //절댓값 최소힙 (절댓값이 같다면 값이 작은 수가 우선순위로)
			if(Math.abs(this.num)==Math.abs(o.num)) return this.num-o.num;
			else return Math.abs(this.num)-Math.abs(o.num);
		}

		@Override
		public String toString() {
			return Integer.toString(num);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int order = Integer.parseInt(br.readLine());
			
			if(order == 0) { //배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}
			else { //배열에 x라는 값을 넣는(추가하는) 연산
				pq.offer(new Number(order));
			}
		}
		
	}
}
