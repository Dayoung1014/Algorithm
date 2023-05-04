package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 육지 : L
 * 바다 : W
 * 상하좌우 육지로만 이동 가능 
 * 한 칸 이동 시 한시간 걸림
 * 
 * 보물은 서로 간 최단거리로 이동하는데 가장 긴 시간이 걸리는 두 곳에 있음
 * 
 * ----------------
 * 
 * 1. bfs : 시작점 하나 정하고 모든 육지를 최단거리로 방문해서 가장 긴 거리 갱신 
 * 2. 시작점을 모든 육지로 해서 bfs 다 돌려보기
 * 
 * algorithm : bfs
 * start time : 23.05.04 11:40
 * finish time : 23.05.04 11:54
 * */

public class Main_2589_보물섬 {
	static int R, C;
	static char[][] map;
	static int maxTime = Integer.MIN_VALUE;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1}; 
	 
	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	 
	static void bfs(int startR, int startC) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		
		q.add(new Point(startR, startC, 0));
		v[startR][startC] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			maxTime = Math.max(maxTime, p.time);
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=R || nc>=C || v[nr][nc] || map[nr][nc]=='W') continue;
				q.add(new Point(nr, nc, p.time+1));
				v[nr][nc] = true;
			}
		}
	} 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 'L') bfs(r,c);
			}
		} 
		System.out.println(maxTime);  
	}
}
