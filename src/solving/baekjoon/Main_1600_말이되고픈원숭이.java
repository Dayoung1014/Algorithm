package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); //가로 길이
		H = Integer.parseInt(st.nextToken()); //세로 길이
		
		map = new int[H][W];
		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		if(res==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
	}
	
	static class Point {
		int r, c, k, cnt; //위치, 남은 K 개수, 움직인 수

		public Point(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}
	
	// k번만 말처럼 움직일 수 있음
	// 장애물 점프 가능
	static int[] horse_r = {-1, -2, -2, -1, 1, 2, 2, 1}; 
	static int[] horse_c = {-2, -1, 1, 2, 2, 1, -1, -2};
		
	// 장애물 방문 불가
	static int[] monkey_r = {-1, 1, 0, 0};
	static int[] monkey_c = {0, 0, -1, 1};
		
	// 동작수의 최솟값을 출력
	// 도착 못하는 경우 -1 출력
	static int W, H, K;
	static int[][] map;
		
	static int res=Integer.MAX_VALUE;
	// 동작 수의 최솟값 구하기
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		ArrayList<Integer> k_cnt = new ArrayList<>();
		boolean[][][] v = new boolean[K+1][H][W];
		
		for (int i = 0; i <= K; i++) {
			v[i][0][0] = true;
		}
		
		q.add(new Point(0, 0, K, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.r == H-1 && p.c==W-1) {
				if(res>p.cnt) {
					res=p.cnt; 
				}
			}

			for (int d = 0; d < 4; d++) { //사방은 언제나 다 이동해봄
				int nr = p.r + monkey_r[d];
				int nc = p.c + monkey_c[d];
				
				if(nr<0 || nc<0 || nr>=H || nc>=W || v[p.k][nr][nc] || map[nr][nc]==1) continue;
				v[p.k][nr][nc] = true;
				q.add(new Point(nr, nc, p.k, p.cnt+1));
			}
			
			if(p.k>0) { //말처럼 움직일 수 있는 경우
				for (int d = 0; d < 8; d++) {
					int nr = p.r + horse_r[d];
					int nc = p.c + horse_c[d];
					
					if(nr<0 || nc<0 || nr>=H || nc>=W || v[p.k-1][nr][nc] || map[nr][nc]==1) continue;
					v[p.k-1][nr][nc] = true;
					q.add(new Point(nr, nc, p.k-1, p.cnt+1));
				}
			}	
		}
	}

}
