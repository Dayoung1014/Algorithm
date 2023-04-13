package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3 {
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
		return (n>=0 && n <= 100000 && !visited[n]);
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