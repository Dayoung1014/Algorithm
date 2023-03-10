package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 빙산을 2차원 배열로 표시 (각 칸의 높이가 양의 정수로, 0은 바다)
 * 
 * 일년마다 동서남북에 붙은 0의 칸 개수만큼 줄어듬
 * 
 * 빙산이 주어졌을 때 두 덩어리 이상으로 분리되는 최초의 시간(년)을 구해라
 * 
 * 줄어드는거 갱신해서
 * 덩어리 개수 체크
 * 
 * */


public class Main_2573_빙산_시간초과 {
	static int N, M;
	static int[][] map;
	static int[][] changed;
	
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] checked;
	static int count;
	static int time;
	
	private static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	private static void check() { //빙산 덩어리 개수 세기
		checked = new boolean[N][M];
		count = 0;
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(map[n][m]!=0 && !checked[n][m]) {
					count++;
					bfs_count(n, m);
				}
			}
		}
	}
	private static void bfs_count(int n, int m) {
		Queue<Point> q = new LinkedList();
		checked[n][m] = true;
		q.offer(new Point(n, m));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue; //범위 벗어난 경우
				if(map[nr][nc]==0) continue; //바다인 경우
				if(checked[nr][nc]) continue; //이미 확인한 경우
				checked[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}
	}
	
	private static void bfs_change(int n, int m) {
		Queue<Point> q = new LinkedList();
		boolean[][] visited = new boolean[N][M];
		visited[n][m] = true;
		q.offer(new Point(n, m));
				 
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int sea = 0; //인접 바다의 개수
			for(int d=0; d<4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue; //범위 벗어난 경우
				if(visited[nr][nc]) continue; //이미 확인한 경우
				if(map[nr][nc]==0) sea++; //바다인 경우 인접 바다 수 증가
				else { // 인접한 곳이 빙산인경우 방문배열 갱신, q에 추가
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc));
				}
				
			}
			if(sea!=0) {
				int after = map[p.r][p.c] - sea;
				if(after < 0) after=0;
				changed[p.r][p.c] = after;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
	
		time=0;
		while(true) {
			check(); //빙산 개수 확인 후
			if(count >= 2) break; //2개 이상 시 break
			
			changed = new int[N][M];
			for(int n=0; n<N; n++) {
				changed[n] = map[n].clone();
				for(int m=0; m<M; m++) {
					if(map[n][m]==0) continue;
					bfs_change(n, m);
				}
			}
			for(int n=0; n<N; n++) {
				map[n] = changed[n].clone();
			}
			time++;
		}
		
		// 정답 출력
		System.out.println(time);
	}
}
