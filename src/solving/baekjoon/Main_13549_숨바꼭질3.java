package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 
 * [현재 위치]
 * - 수빈이 : 점 N
 * - 동생 : 점 K
 * 
 * [수빈이의 행동]
 * - 걷기 : 1초 동안, 현재위치 +1, -1 가능 
 * - 순간이동 : 0초 동안, 현재위치*2
 * 
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간 몇 초인가?
 * */

public class Main_13549_숨바꼭질3 {
	static int N;
	static int K;
	static boolean[] visited;
	
	static class Point implements Comparable<Point>{
		int p;
		int time;

		public Point(int p, int time) {
			super();
			this.p = p;
			this.time = time;
		}


		@Override
		public int compareTo(Point o) {
			return this.time-o.time;
		}
	}
	
	static void bfs() {
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.offer(new Point(N, 0));
		//visited[N] = true;
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			System.out.println(point.p);

			if(point.p == K) {
				System.out.println(point.time);
				return;
			}

			if(check(point.p*2)) {
				q.offer(new Point(point.p*2, point.time));
				visited[point.p*2] = true;
			}

			if(check(point.p-1)) {
				q.offer(new Point(point.p-1, point.time+1));
				visited[point.p-1] = true;
			}
			
			if(check(point.p+1)) {
				q.offer(new Point(point.p+1, point.time+1));
				visited[point.p+1] = true;
			}
		}
	}
	
	static boolean check(int n) {
		return (n>=0 && n <= 100000); // && !visited[n]
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //수빈이 위치
		K = Integer.parseInt(st.nextToken()); //동생 위치
		visited = new boolean[100001];
		
		bfs();
	}

}
