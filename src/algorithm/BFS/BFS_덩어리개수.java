package algorithm.BFS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 4방으로 연결된 1의 덩어리 갯수 세기
 *
 */

public class BFS_덩어리개수 {
	static int[][] map;

	static int N = 6;
	static int M = 6;
	
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner("0 0 0 0 0 0\n"
											+ "1 1 1 1 1 0\n"
											+ "0 1 1 0 0 0\n"
											+ "0 0 0 1 1 0\n"
											+ "0 0 0 0 1 0\n"
											+ "0 0 0 0 0 0\n");

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[N][M];
		
		v[r][c] = true;
		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = 0; //확인 후 다른 것으로 변경
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if (v[nr][nc] || map[nr][nc] == 0) continue;
				v[nr][nc] = true;
				Q.add(new Point(nr, nc));
			}
		}
	}
}
