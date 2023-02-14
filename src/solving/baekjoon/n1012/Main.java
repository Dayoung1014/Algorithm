package solving.baekjoon.n1012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * 배추지렁이 : 배추 근처에 서식하며 해충을 잡아 먹음으로써 보호함
 * 어떤 배추에 살고 있다면 인접한 다른 배추로 이동할 수 있어
 * 인접 : 상하좌우 (대각선 안됨)
 * 
 * 배추들이 퍼져있는게 몇 구역인지 -> 구역당 하나 필요
 * 
 * 1: 배추
 * 0: 그냥 땅
 * */

public class Main {
	static int M;
	static int N; 
	static int[][] map;
	static boolean finish;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println(Arrays.toString(new int[10]));
		int T = sc.nextInt(); // 테스트 케이스 개수
		for(int t=0; t<T; t++) {
			M = sc.nextInt(); // 밭의 가로 길이
			N = sc.nextInt(); // 밭의 세로 길이
			int K = sc.nextInt(); // 심어진 배추 위치 개수
			
			map = new int[N][M];
			for(int i=0; i<K; i++) {
				int x = sc.nextInt(); //가로 위치
				int y = sc.nextInt(); //세로 위치
				map[y][x] = 1;
			}
			
			int sum=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						sum++;
						bfs(i, j);
					}
				}
			}
			System.out.println(sum);
		}

	}
	
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

	private static void bfs(int r, int c) {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[N][M];
		v[r][c] = true;

		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				// 지도안에 있다면
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					Q.add(new Point(nr, nc));
				}
//			while(!finish) {
//				
//					else {
//						finish = true; //돌던 4방만 마져 돌고 while 종료
//					}
//				}
			}
		}
	}

}
