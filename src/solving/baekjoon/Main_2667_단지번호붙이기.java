package solving.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * 1은 집 있음
 * 0은 집 없음 
 * 연결된 집의 모임인 단지를 정의 (좌우, 아래위 연결된게 단지 / 대각선은 아님)
 * -> 총 단지수, 단지내 집 수를 오름차순으로 정렬하여 출력
 * 
 * 
 * */

public class Main_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static ArrayList<Integer> home;
	static int sum=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str  = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		int sum=0;
		home = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					home.add(1);
					sum++;
					bfs(i, j);
				}
			}
		}
		System.out.println(sum);
		Collections.sort(home);
		for(int h:home) {
			System.out.println(h);
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
		boolean[][] v = new boolean[N][N];
		v[r][c] = true;

		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				// 지도안에 있다면
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
					int cnt = home.get(home.size()-1);
					home.remove(home.size()-1);
					home.add(cnt+1);
					v[nr][nc] = true;
					Q.add(new Point(nr, nc));
				}
			}
		}
	}

}
