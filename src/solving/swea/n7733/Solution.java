package solving.swea.n7733;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 치즈
 * - N*N 
 * - 각 칸에 맛있는 정도가 1~100으로 표현
 * 
 * 
 * 요정
 * - 100일 동안 갉아먹음
 * - x일에 맛있는 정도가 x인 치즈 다 먹음
 * 
 * 
 * 구하려는 것
 * - 100일 중 상하좌우 인접한  치즈덩어리가 가장 많을 때의 수
 * 
 * 
 * 구현 
 * 1. 1~100일 x 맛있는 치즈 먹어서 0으로 바꾸기
 * 2. 치즈 덩어리 개수 구하는 것
 * 
 * 1 반복문 안에서 2 구해서 최대값 갱신하면 됨
 * 
 * */

import java.util.Scanner;

class Solution {
	static int N;
	static int[][] cheese;
	static boolean[][] visited;
	static int count;
	public static void main(String args[]) throws Exception {
	
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			count = 0;
			N = sc.nextInt();
			cheese = new int[N][N];
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					cheese[i][j] = sc.nextInt();
				}
			}
			
		
			// 100일 동안 치즈 먹기 (먹은 칸은 0으로 변경)
			for(int day=1; day<=100; day++) {
				int exist=0;
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(cheese[i][j] == day) {
							cheese[i][j] = 0;
							exist++;
						}
					}
				}
				if(exist!=0) { 
					visited = new boolean[N][N];
					//하루씩 지날 때 bfs 호출
					int cnt = 0;
					for(int i=0; i<N; i++) {
						for(int j=0; j<N; j++) {
							if(cheese[i][j] !=0 &&  !visited[i][j]) {
								cnt++;
								bfs(i, j);
								
							}
						}
					}
					System.out.println("day "+day+" / "+cnt );
					if(count < cnt) count = cnt;
				}
				
			}
			
			System.out.println("#"+test_case+" "+count);
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
		Queue<Point> Q = new LinkedList();
		visited[r][c] = true;

		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && cheese[nr][nc] != 0) {
					visited[nr][nc] = true;
					Q.add(new Point(nr, nc));
				}
			}
		}
	}
	
	
}