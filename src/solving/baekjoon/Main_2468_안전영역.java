package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 해당 영역의 모든 Point 를 끝까지 빠르게 탐색 -> DFS(빠름) BFS(느림)
 * 
 * 처음에 BFS로 구현해서 메모리 초과
 * DFS로 수정 후 통과 함
 * 
 * */

public class Main_2468_안전영역 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static boolean[][] v;
	
	static int tmpArea;
	static int result = 1;
	
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
	static void dfs(int rain, int r, int c) {
		v[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nc<0 || nr>=N || nc>=N ) continue;
			if(!v[nr][nc] && map[nr][nc]>rain) {
				dfs(rain, nr, nc);
			}
		}
	
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int minH = 100;
		int maxH = 1;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, map[i][j]);
				maxH = Math.max(maxH, map[i][j]);
			}
		}

		for(int rain=minH; rain<maxH; rain++) {
			tmpArea = 0;
			v = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!v[i][j] && map[i][j] > rain) {
						tmpArea++;
						dfs(rain, i, j);
					}
				}
			}
			result = Math.max(result, tmpArea);
		}
		
		System.out.println(result);
	}

}
