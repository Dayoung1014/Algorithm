package solving.baekjoon.n1926;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 도화지에 그림이 그려있음
 * 그림의 개수, 가장 넓은 그림의 넓이 구하기
 * 인점 (4방)
 * */

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	static boolean[][] visited;
	static int total;
	static int maxArea;
	static int area;
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(nc<0 || nc>n || nr<0 || nr>n) continue;
				if(map[nr][nc]==0) continue;
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		visited = new boolean[n][m];
		total=0; maxArea=0; area=0;

	}

}
