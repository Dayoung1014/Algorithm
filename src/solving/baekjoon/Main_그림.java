package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


/*
 * 도화지에 그림이 그려있음
 * 그림의 개수, 가장 넓은 그림의 넓이 구하기
 * 인점 (4방)
 * */

// Scanner 사용 시 메모리 초과 남
public class Main_그림 {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited ;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
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
		area = 0;
		Queue<Point> q = new LinkedList<>();
		visited[r][c] = true;
		q.offer(new Point(r, c));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.r][p.c] = 0;
			area++;
			for(int i=0; i<4; i++) {
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				
				if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
				if(visited[nr][nc] || map[nr][nc]==0) continue;
				visited[nr][nc] = true;
				q.add(new Point(nr, nc));

			}
		}
		if(area > maxArea) maxArea = area;
		
	}
	
	static void dfs(int r, int c) {
		area = 0;
		Stack<Point> stack = new Stack<>();
		visited[r][c] = true;
		stack.add(new Point(r, c));
		
		while(!stack.isEmpty()) {
			Point p = stack.pop();
			map[p.r][p.c] = 0;
			area++;
			for(int i=0; i<4; i++) {
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				
				if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
				if(visited[nr][nc] || map[nr][nc]==0) continue;
				visited[nr][nc] = true;
				stack.add(new Point(nr, nc));

			}
		}
		if(area > maxArea) maxArea = area;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		total=0; maxArea=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0 || visited[i][j])  continue;
				total++;
				bfs(i, j);
			}
		}
		System.out.println(total);
		System.out.println(maxArea);
	}

}
