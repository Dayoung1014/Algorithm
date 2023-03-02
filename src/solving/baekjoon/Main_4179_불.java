package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 지훈이가 불에 타기 전 탈출 할 수 있는가 
 * 얼마나 빨리 탈출 할 수 있는가
 * 
 * 지훈이 : 수평, 수직으로 이동, 불&벽 통과 못함
 * 불 : 수평, 수직으로 이동, 벽 통과 못함
 * 탈출 : 가장자리와 접한 곳
 * 
 * # : 벽
 *	. : 지나갈 수 있는 공간
 *	J : 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
 *	F : 불이 난 공간
 *
 * 불이 1개라는 조건이 없을 경우 안전하게 여러개 있다고 생각하고 풀어야 함
 * */

public class Main_4179_불 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C;
	static char[][] map;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};
	
    static boolean[][] v;
    static int result;
	static class Point {
		int r, c, time;
		boolean isFire;
		
		public Point(int r, int c, int time, boolean isFire) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.isFire = isFire;
		}
	}
	private static int bfs(int person[]) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		
		for (int r = 0; r < R; r++) {
			for (int c= 0; c < C; c++) {
				if(map[r][c] == 'F') {
					q.offer(new Point(r, c, 0, true));
					v[r][c] = true;
				}
			}
		}
		
		q.offer(new Point(person[0], person[1], 0, false));
		v[person[0]][person[1]] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(p.isFire) {
                	if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
                	if(v[nr][nc]) continue;
                	if(map[nr][nc]=='#') continue;
                	v[nr][nc] = true;
                	q.offer(new Point(nr, nc, p.time+1, true));
                	map[nr][nc] = 'F';
                }
                else {
                	if(nr<0 || nc<0 || nr>=R || nc>=C) return p.time+1;
                	if(v[nr][nc]) continue;
                	if(map[nr][nc]=='#' || map[nr][nc]=='F' ) continue;
                	v[nr][nc] = true;
                	q.offer(new Point(nr, nc, p.time+1, false));
                }
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] person = new int[2];
		int[] fire = new int[2];
		map = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			for (int c= 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == 'J') {
					person[0] = r;
					person[1] = c;
				}
			}
		}
		

		int result = bfs(person);
		if(result == -1) System.out.println("IMPOSSIBLE");
		else System.out.println(result);
		
		
		
	}

}
