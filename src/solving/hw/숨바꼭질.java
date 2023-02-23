package solving.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * [현재 위치]
 * - 수빈이 : 점 N
 * - 동생 : 점 K
 * 
 * [수빈이의 행동]
 * - 걷기 : 1초 동안, 현재위치 +1, -1 가능 
 * - 순간이동 : 1초 동안, 현재위치*2
 * 
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간 몇 초인가?
 * */

public class 숨바꼭질 {
	static int N;
	static int K;
	static boolean[] visited;
	
	static class Point {
		int p;
		int time;

		public Point(int p, int time) {
			super();
			this.p = p;
			this.time = time;
		}
		
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(N, 0));
		visited[N] = true;
		while(!q.isEmpty()) {
			Point point = q.poll();
			
			if(point.p == K) {
				System.out.println(point.time);
				break;
			}
			
			for(int i=0; i<3; i++) {
				int np = point.p;
				if(i == 0)  {
					np -= 1;
				}
				else if(i == 1) {
					np += 1;
				}
				else {
					np *= 2;
				}
				if(np<0 || np >= 100001 || visited[np]) continue;
				q.offer(new Point(np, point.time+1));
				visited[np] = true;
			}
			
		}
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
