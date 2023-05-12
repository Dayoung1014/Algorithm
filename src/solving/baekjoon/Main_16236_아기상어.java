package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N*N 공간에 물고기M마리 아기상어1마리 (한칸에는 최대1마리)
 * 
 * 아기상어
 * - 1초에 상하좌우 인접한 곳 이동
 * - 자신의 크기보다 큰 물고기는 지날 수 없음
 * - 자신의 크기보다 작은 물고기 지나가면서 먹을 수 있음
 * - 자신의 크기와 같은 물고기는 먹을 수 없지만 지나갈 수 있음
 * 
 * - 더 이상 먹을 수 있는 물고기가 공간에 없다면 엄마에게 도음 요청
 * - 먹을 수 있는 물고기가 1마리라면 그거 먹으러 감
 * - 먹을 수 있는 물고기가 1마리 이상이면 가장 가까운 물고기 먹으러 감 (이동할 때 최소로 감)
 * - 가장 가까운 물고기가 여러 마리라면 가장 위 -> 가장 왼쪽부터 먹음
 * 
 * - 상어 사이즈는 2부터 시작
 * - 상어는 자신의 크기만큼 물고기수를 먹으면 크기가 1 증가
 * - 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간 
 * */

public class Main_16236_아기상어 {
	static int N;
	static int[][] map;
	static class Point {
		int r,c;
		int eat; //먹은 물고기 수
		int size; //상어 사이즈
		int time; //시간
		public Point(int r, int c, int eat, int size, int time) {
			super();
			this.r = r;
			this.c = c;
			this.eat = eat;
			this.size = size;
			this.time = time;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static void bfs(int startR, int startC) {
		 Queue<Point> q = new LinkedList<>();
		 boolean[][] v = new boolean[N][N];
		 q.add(new Point(startR, startC, 0, 2, 0));
		 v[startR][startC] = true;
		 
		 while(!q.isEmpty()) {
			 Point p = q.poll();
			 
			 
			 
			 
		 }
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int startR=0, startC=0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 9) {
					startR = r; startC = c;
				}
			}
		}
		
		bfs(startR, startC);
		
		
		
		
	}

}
