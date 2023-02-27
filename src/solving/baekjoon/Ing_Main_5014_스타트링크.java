package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * F층으로 이루어진 건물
 * 스타트링크는 G층
 * 
 * 엘리베이터 버튼 U( 위로  U층 ) / D( 아래로 D층 ) -> 해당하는 층 없으면 움직이지 않음
 *
 * 처음에는 dfs 생각했지만 최단 경로 구하면 되는 것이므로 bfs가 더 효율적
 * */


public class Ing_Main_5014_스타트링크 {
	static int F, S, G, U, D;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int result = 0;

	static class Point {
		int now, count;

		public Point(int now, int count) {
			this.now = now;
			this.count = count;
		}
	}
	private static int bfs(int start) {
		Queue<Point> q = new LinkedList<>();
		boolean[] v = new boolean[F+1];

		v[start] = true;
		q.offer(new Point(start, 0));

		while(!q.isEmpty()) {
			Point top = q.poll();
			if(top.now == G) return top.count;

			for(int d=0; d<2; d++) {
				int now=0;
				if(d==0) {
					now = top.now - D;
				}
				else if (d==1) {
					now = top.now + U;
				}

				if(now < 1 || now > F || v[now]) continue;
				//System.out.println("now " + now);
				v[now]=true;
				q.offer(new Point(now, top.count+1));


			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); // 건물 총 층수
		S= Integer.parseInt(st.nextToken()); // 현재 위치 층
		G = Integer.parseInt(st.nextToken()); //목적지 층
		U = Integer.parseInt(st.nextToken()); //위로 U칸 버튼
		D = Integer.parseInt(st.nextToken()); //위로 D칸 버튼


		int result = bfs(S);
		if(result != -1) System.out.println(result);
		else System.out.println("use the stairs");
	}

}
