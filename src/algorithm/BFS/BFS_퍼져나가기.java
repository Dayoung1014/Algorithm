package algorithm.BFS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 1 의 값이 사방으로 퍼지는데 걸리는 최소 count 구하세요
 *
 */

public class BFS_퍼져나가기 {
	static int N = 6;
	static int M = 6;
	static int[][] map;
	static int count = 0;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner("0 0 0 0 0 0\n"
											+ "0 1 0 0 0 0\n"
											+ "0 0 0 0 0 0\n"
											+ "0 0 0 0 1 0\n"
											+ "0 0 0 0 0 0\n"
											+ "0 0 0 0 0 0\n");

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		bfs();
		
		print();
		System.out.println(count);
	}

	private static void bfs() {
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					v[r][c] = true;
					Q.offer(new Point(r, c, 0));
				}
			}
		}
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			print();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if (v[nr][nc] || map[nr][nc] == 1) continue;
				v[nr][nc] = true;
				Q.add(new Point(nr, nc, p.cnt + 1));
				count = Math.max(count, p.cnt + 1);
			}
		}
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				 System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
