package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  오직 가로와 세로로만 움직일 수 있다
 * 모든 지점에 대해서 목표지점까지의 거리를 구하기
 * 
 * 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점(단 1개)
 * 
 * 원래 갈 수 없는 땅인 곳은 0
 * 원래 갈 수 있는 땅인 곳 중 도달할 수 없다면 -1
 * */

public class Main_14940_쉬운최단거리 {
	static int n, m;
	static int[][] map;
	static int[] finish = new int[2];
	static int[][] result;
	static boolean[][] v;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
//	static int bfs(int startR, int startC) {
//		Queue<Point> q = new LinkedList<>();
//		boolean[][] v = new boolean[n][m];
//		v[startR][startC] = true;
//		q.add(new Point(startR, startC, 0));
//		
//		while(!q.isEmpty()) {
//			Point p = q.poll();
//			
//			if(p.r == finish[0] && p.c == finish[1]) return p.len;
//			
//			for (int d = 0; d < 4; d++) {
//				int nr = p.r + dr[d];
//				int nc = p.c + dc[d];
//				if(nr<0 || nc<0 || nr>=n || nc>=m || v[nr][nc] || map[nr][nc]==0) continue;
//				if(result[nr][nc] == -1) return -1;
//				if(result[nr][nc] !=0) return (p.len+1)+result[nr][nc];
//				
//				v[nr][nc] = true;
//				q.add(new Point(nr, nc, p.len+1));
//			}
//			
//		}
//		return -1;
//	}
	
	static void bfs(int R, int C) {
		Queue<Point> q = new LinkedList<>();
		v = new boolean[n][m];
		v[R][C] = true;
		q.add(new Point(R, C));
		result[R][C] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr<0 || nc<0 || nr>=n || nc>=m ) continue; 
				
				if(map[nr][nc] == 0) continue; // 방문 불가
				if(v[nr][nc]) continue; //이미 방문
				
				// 도착
				v[nr][nc] = true;
				q.add(new Point(nr, nc));
				result[nr][nc] = result[p.r][p.c]+1;
			}
		}
}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m]; 
		result = new int[n][m]; 
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) {
					finish[0] = i;
					finish[1] = j;
				}
			}
		}
		
		bfs(finish[0], finish[1]);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!v[i][j] && map[i][j]==1) sb.append(-1+" "); //출발할 수 있는 곳인다 가다 끊기는 경우
				else 
				sb.append(result[i][j]+" "); 
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
