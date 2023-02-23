package solving.swea.n7793;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 이전 코드에서 틀린 이유 : bfs호출 시 악마, 수연 위치 넘겨줬음
 * 악마가 1개라는 조건이 없으므로 틀렸음
 * */

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

	static int N, M;
	static Character[][] map;
	
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	static int mincnt ;
	static class Point {
		int r, c, cnt;
		char name;

		public Point(int r, int c, int cnt, char name) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.name = name;
		}
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		mincnt = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == '*') {
					visited[i][j] = true;
					queue.offer(new Point(i, j, 0, '*')); 
				}
			}
		}
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'S') {
					visited[i][j] = true;
					queue.offer(new Point(i, j, 0, 'S')); 
				}
			}
		}
		
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();

			if(p.name=='S' && map[p.r][p.c]=='D') {
				mincnt = Math.min(p.cnt, mincnt);
				return;
			}
			
			for(int i=0; i<4; i++) { 
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr<0 || nc<0 || nr>= N || nc>=M || visited[nr][nc]) continue;
				if(p.name=='S' && map[nr][nc] != 'X' && map[nr][nc] != '*') { //수연이
					visited[nr][nc]=true;
					queue.offer(new Point(nr, nc, p.cnt+1, p.name));
                }
                else if(p.name=='*' && map[nr][nc] != 'X' && map[nr][nc]!='D') { //악마
                	visited[nr][nc]=true;
                    queue.offer(new Point(nr, nc, p.cnt+1, p.name));
                }
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		int T= Integer.parseInt(br.readLine()); ;
	
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N행
			M = Integer.parseInt(st.nextToken());  // M열
			
			map = new Character[N][M];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j] =str.charAt(j);
				}
			}
			
			bfs();
			
			System.out.print("#"+test_case+" ");
			if(mincnt!=Integer.MAX_VALUE) System.out.println(mincnt);
			else System.out.println("GAME OVER");
		}
	}
}
