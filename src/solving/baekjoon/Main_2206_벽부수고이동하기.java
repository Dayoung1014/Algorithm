package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 
 *  이때 최단 경로로 이동하려 한다. 
 *  최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
 * */

public class Main_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
 
		bfs();
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	static class Point{
		int r, c, cnt;
		boolean breakWall;
		public Point(int r, int c, int cnt, boolean breakWall) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.breakWall = breakWall;
		}  
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int min = Integer.MAX_VALUE; 
	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][][] v = new boolean[2][N][M]; //벽 안부숨 // 벽 부숨
		q.add(new Point(0, 0, 1, false));
		v[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll(); 
			if(now.r == N-1 && now.c == M-1) {
				min = Math.min(min, now.cnt);
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = now.r+dr[d];
				int nc = now.c+dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				
				if(map[nr][nc] == 1) { //벽인데 
					if(!now.breakWall) { //부순적 없는 경우
						v[1][nr][nc] = true; //부수고 가기
						q.add(new Point(nr, nc, now.cnt+1, !now.breakWall));
					}
					else continue; //벽인데 부순적 있다면 더 이상 갈 수 없음
				}
				
				else { //벽이 아닌데
					if(now.breakWall && !v[1][nr][nc]) { //방문한적 없는 경우 가기
						v[1][nr][nc] = true;
						q.add(new Point(nr, nc, now.cnt+1, now.breakWall));
					}
					else if(!now.breakWall && !v[0][nr][nc]){ //방문한적 없는 경우 가기
						v[0][nr][nc] = true;
						q.add(new Point(nr, nc, now.cnt+1, now.breakWall));
					}
				}
			
			}
		}
	}
}
