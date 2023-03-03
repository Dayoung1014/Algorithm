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

public class Main_2206_벽부수고이동하기2 {
	static int N, M; 
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	static int result = Integer.MAX_VALUE;
	
	static boolean breakOne = false; // 벽 부수기 여부 / 1번 부순 후 true
	
	static class Point {
		int r, c, cnt;
		boolean breakOne;
		public Point(int r, int c, int cnt, boolean breakOne) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.breakOne = breakOne;
		}
		
		
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][][] v = new boolean[N][M][2]; //부수지 않음 / 부숨
		q.offer(new Point(0,0,1, false));

		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.r == N-1 && p.c == M-1) {
				result = p.cnt;
				return;
			}
			
			for(int d=0; d<4; d++) { //상하좌우	
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];

				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				
				if(map[nr][nc] == 0) { // 벽이 아닌경우
					
					if(p.breakOne) { //벽 부순적 있는 경우
						v[nr][nc][0] = true;
						q.offer(new Point(nr, nc, p.cnt+1, true));
					}
					else { //벽 부순적 없는 경우
						v[nr][nc][1] = true;
						q.offer(new Point(nr, nc, p.cnt+1, false));
					}
				}
				else if (!p.breakOne){ // 벽이지만 부술 수 있는 경우
					q.offer(new Point(nr, nc, p.cnt+1, true));
					v[nr][nc][1] = true;
				}
	
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
