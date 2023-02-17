package algorithm.permutation_combination_subset;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BFS_DFS {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited ;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
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
		visited[r][c] = true;
		q.offer(new Point(r, c));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.r][p.c] = 0;
			for(int i=0; i<4; i++) {
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				
				if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
				if(visited[nr][nc] || map[nr][nc]==0) continue;
				visited[nr][nc] = true;
				q.add(new Point(nr, nc));

			}
		}
		
	}
	
	static void dfs(int r, int c) {
		Stack<Point> stack = new Stack<>();
		visited[r][c] = true;
		stack.add(new Point(r, c));
		
		while(!stack.isEmpty()) {
			Point p = stack.pop();
			map[p.r][p.c] = 0;
			for(int i=0; i<4; i++) {
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				
				if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
				if(visited[nr][nc] || map[nr][nc]==0) continue;
				visited[nr][nc] = true;
				stack.add(new Point(nr, nc));
			}
		}
		
	}
	
}


