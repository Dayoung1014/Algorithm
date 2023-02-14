package solving.baekjoon.n7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * 익은 토마토 주변(4방 상하좌우) 토마토들은 하루 뒤 익게됨
 * 저절로 익을 수 없음
 * 며칠이 지나야 다 익는지 최소 일수 알고 싶음
 * 
 * 단 토마토가 비어있는 칸이 있을 수 있음
 * 
 * 1: 익은 토마토
 * 0 : 익지 않은 토마토
 * -1 : 들어있지 않은 칸
 * */

public class Main {
	static int M;
	static int N;
	static int[][] map;
	static int day = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); //상자 가로 칸 수
		int N = sc.nextInt(); //상자 세로 칸 수
		map = new int[N][M];
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				map[n][m] = sc.nextInt();
			}
		}
		
		bfs();
		System.out.println(day);
	}
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

	private static void bfs() {
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				 System.out.print(map[n][m] + " ");
			}
			System.out.println();
		}
		System.out.println();
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					Q.offer(new Point(r, c, 0));
					v[r][c] = true;
				}
			}
		}
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = -0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				// 지도안에 있다면
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					Q.add(new Point(nr, nc, p.cnt + 1));
					day = Math.min(day, p.cnt + 1);
				}
			}
		}
	}

}
