package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N*M 맵
 * 0 이동가능
 * 1 이동 불가
 * 1,1, 에서 N, M까지 이동하려 함
 * 한개의 벽을 이동했을 때 경로가 짧아진다면 벽 하나까지는 부술 수 있음
 * 최단 거리 구하기 (시작, 끝 칸 포함해서)
 * */

public class Main_2206_벽부수고이동하기 {
	static int N, M; 
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	static int result = Integer.MAX_VALUE;
	
	static boolean breakOne = false; // 벽 부수기 여부 / 1번 부순 후 true
	
	static class Point {
		int r, c, cnt;
		boolean breakOne;
		boolean[][] v;
		public Point(int r, int c, int cnt, boolean breakOne, boolean[][] v) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.breakOne = breakOne;
			this.v = v;
		}
		
		
	}
	
	static boolean[][] visit;
	
//	static void dfs(int r, int c, int len) {
//		System.out.println(r + " "+ c + " "+breakOne+ " "+len);
//		
//		visit[r][c] = true;
//		if(r==N && c==M) {
//			result = Math.min(result, len);
//			return;
//		}
//		
//		//boolean[] wall = new boolean[4];
//		
//		for(int d=0; d<4; d++) {
//			int nr = r + dr[d];
//			int nc = c + dc[d];
//			
//			if(nr<1 || nc<1 || nr>N || nc>M ) continue;
//			if(visit[nr][nc]) continue;
//			if(map[nr][nc] == 0) {
//				dfs(nr, nc, len+1);
//			}
//			else if (!breakOne){ // 부수는 기회가 있는 경우
//				breakOne = true;
//				dfs(nr, nc, len+1);
//			}
//		}
//	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		//boolean[][] v = new boolean[N][M];
		//v[0][0] = true;
		q.offer(new Point(0,0,1, false, new boolean[N][M]));

		while(!q.isEmpty()) {
			Point p = q.poll();
			p.v[p.r][p.c] = true;
			System.out.println();
			for(int n=0; n<N; n++) {
				System.out.println(Arrays.toString(p.v[n]));
			}
			
			
			for(int d=0; d<4; d++) { //상하좌우	
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				if(nr==N-1 && nc==M-1) {
					result = Math.min(result, p.cnt+1);
				}
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(p.v[nr][nc]) continue;
				if(map[nr][nc] == 0) { // 벽이 아닌경우
					//p.v[nr][nc] = true;
					q.offer(new Point(nr, nc, p.cnt+1, p.breakOne, p.v));
					System.out.print("길 ");
					System.out.println(p.r+" "+p.c+" -> "+nr + " "+ nc + " "+p.breakOne + " "+(p.cnt+1));
				}
				else if (!p.breakOne){ // 벽이지만 부수는 기회가 있는 경우
					//p.v[nr][nc] = true;
					q.offer(new Point(nr, nc, p.cnt+1, true, p.v));
					System.out.print("벽부숨 ");
					System.out.println(p.r+" "+p.c+" -> "+nr + " "+ nc + " "+true + " "+(p.cnt+1));
				}
				else System.out.println("안넣고 나감 " + nr + " " +nc);
	
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		//visit = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = Character.getNumericValue(str.charAt(m));
			}
		}
		
//		for(int n=0; n<N; n++) {
//			System.out.println(Arrays.toString(map[n]));
//		}
		
		
		//dfs(1, 1, 1);
		bfs();
		if(N==1&&M==1) System.out.println(1);
		else if(result==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
}
