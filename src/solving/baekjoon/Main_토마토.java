package solving.baekjoon;

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

// 정답 코드

public class Main_토마토 {
	static class Tomato {
		int r, c;

		public Tomato(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int M;
	static int N;
	static int[][] map;
	static int day = 0;
	static Queue<Tomato> q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); //상자 가로 칸 수
		N = sc.nextInt(); //상자 세로 칸 수
		map = new int[N][M];
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				map[n][m] = sc.nextInt();
				if(map[n][m] == 1) {
					q.add(new Tomato(n, m));
				}
			}
		}
		
		System.out.println(bfs());
	}
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };



	private static int bfs() {
		
		while (!q.isEmpty()) {
			Tomato p = q.poll();
			
			//map[p.r][p.c] = 1;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				 if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(map[nr][nc] == 0) { //토마토가 안익었다면
						q.add(new Tomato(nr, nc));
						map[nr][nc] = map[p.r][p.c]+1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		if(checkZero()) { 
			return -1;
		}
		else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					max = Math.max(max, map[i][j]);
				}
			}
			return max-1;
		}


	}
	
	private static boolean checkZero() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					return true;
				}
			}
		}
		return false;
	}
}
