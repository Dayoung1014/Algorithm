package solving.baekjoon.n2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 미로에서 1(이동 가능) / 0(이동 불가)
 * (1, 1) -> (N, M) 이동하는 최소 경로(이동하는 칸수 구하기)
 * 칸수에는 시작칸, 끝칸도 포함
 * 인접 : 4방
 * */

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int level;
	
	static class Point{
		int r,c,data, level;

		public Point(int r, int c,  int level) {
			super();
			this.r = r;
			this.c = c;
			this.level = level;
		}
		
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList();
		q.offer(new Point(0,0,1));
		v[0][0]=true;
		
		L:while(!q.isEmpty()) {
				Point p = q.poll();
				if(p.r==N-1&&p.c==M-1) { 
					System.out.println(p.level);
					break L;
				}
				for (int d = 0; d < 4; d++) {
					int nr = p.r+dr[d];
					int nc = p.c+dc[d];
					if(nr<0 || nr >= N || nc<0 || nc >= M ) continue;
					if(v[nr][nc] || map[nr][nc]==0) continue;
					v[nr][nc]=true;
					q.add(new Point(nr,nc, p.level+1));
				}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = Character.getNumericValue(str.charAt(m));
			}
		}
		bfs();
	}

}
