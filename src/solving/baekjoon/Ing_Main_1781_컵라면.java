package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * N개의 문제를 주고 각 문제를 풀었을 때 라면 주기로 함
 * 단 각 문제에 대해 데드라인(시간)과 컵라면수(맞췄을 때 주는) 정해져 있음
 * 
 * 받을 수 있는 최대 컵라면 수
 * */

public class Ing_Main_1781_컵라면 {
	static class Ramen implements Comparable<Ramen>{
		int time;
		long cnt;

		public Ramen(int time, long cnt) {
			super();
			this.time = time;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Ramen o) { //max 
			if(this.time==o.time) { //시간이 같다면
				return (int) (o.cnt-this.cnt); // 개수가 큰거부터
			}
			else { //아니라면 시간이 큰거부터
				return o.time-this.time;
			}
		}

		@Override
		public String toString() {
			return "Ramen [time=" + time + ", cnt=" + cnt + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Ramen> pq = new PriorityQueue<>();
		
		int maxTime = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			if(time>maxTime) maxTime = time;
			long cnt = Long.parseLong(st.nextToken());
			pq.add(new Ramen(time, cnt));
		}
		
		long result=0;
		
		for (int t =maxTime; t >=1; t--) {
			while(!pq.isEmpty()) { //pq.peek 시간이 현재 시간보다 작다면 poll (지나간 문제 빼기)
				if(pq.peek().time<t) {
					pq.poll();
				}
			}
			
			if(pq.isEmpty()) break;
			
			System.out.println(t);
			System.out.println(pq.toString());
			System.out.println();
			
			if(pq.peek().time >= t) {
				result += pq.poll().cnt;
			}
			// 현재 시간까지 poll 해서 max값 더해줌
		}
		
		System.out.println(result);
	}
}
