package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 빙산 녹일 때 사방 탐색으로 보지 말고 먼저 빙산 부분 q에 넣어준 후 
 * q 비워질 때 까지 녹이기
 * */

public class Main_2573_빙산 {
	static int N, M;
	static int[][] map;
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
				if(map[n][m]>0 && !checked[n][m]) {
					count++;
					dfs(n, m);
				}
			}
		}
	}
	
	private static void dfs(int r, int c) {
		checked[r][c] = true;
        for (int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr< 0 || nc < 0 || nr >= N || nc >= M)  continue; 
            if (!checked[nr][nc] && map[nr][nc] > 0) dfs(nr,nc);
        }
    }
	
	private static void melt() {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visited = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(map[n][m]!=0) {
					q.add(new Point(n, m));
					visited[n][m] = true;
				}
			}
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int sea = 0; //인접 바다의 개수
			for(int d=0; d<4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue; //범위 벗어난 경우
				if(map[nr][nc]==0 && !visited[nr][nc]) sea++; //바다인 경우 인접 바다 수 증가
			}
			int after = map[p.r][p.c] - sea;
			if(after < 0) after=0;
			map[p.r][p.c] = after;
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
			else if(count==0) { //분리되지 않고 다 녹아버리면 0
				time = 0; 
				break;
			}
			
			melt();
			time++;
		}
		
		// 정답 출력
		System.out.println(time);
	}
}
