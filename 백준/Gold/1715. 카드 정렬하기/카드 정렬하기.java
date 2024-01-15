import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 * 정렬된 두 묶음의 숫자 카드가 있음
 * 
 * 많은 카드 묶음이 있을 때
 * 묶음을 고르는 순서에 따라 비교 횟수가 달라짐
 * 
 * -> 카드 개수 비슷한 것 끼리 비교해야함
 * */

public class Main {
	static class Cards implements Comparable<Cards>{
		int count;

		
		public Cards(int count) {
			super();
			this.count = count;
		}


		@Override
		public int compareTo(Cards o) {
			return this.count-o.count;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Cards> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(br.readLine());
			pq.add(new Cards(c));
		}
		
		int result=0;
		
		while(true) {
			if(pq.size()==1) break;
			Cards A = pq.poll();
			Cards B = pq.poll();
			int count = A.count + B.count;
			result += count;
			pq.add(new Cards(count));
		}
		
		System.out.println(result);
	}
}