package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 티떱숲의 지도는 R행 C열
 * 비어있는 곳은 '.'
 * 물이 차있는 지역은 '*'
 * 돌은 'X'
 * 비버의 굴은 'D'
 * 고슴도치의 위치는 'S'
 * 
 * 고슴도치가 비버의 굴로 가능한 빨리 도착해야 함
 * 
 * 매 분마다
 * 고슴도치는 4방 이동 가능 (물, 돌 이동 불가)
 * 물도 4방으로 이동 (돌, 비버의 소굴로 이동 불가)
 * */

public class Main_3055_탈출 {
	static int R, C;
	static char[][] map;
	static int startR, startC, endR, endC;
	static int time;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Pos {
		int r, c, t;
		boolean isWater;
		public Pos(int r, int c, int t, boolean isWater) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
			this.isWater = isWater;
		}
		
	}

	
	static void bfs(int startR, int startC) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		
		
		// 초기 물 위치 설정
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]=='*') {
					v[i][j] = true;
					q.add(new Pos(i, j, 0, true));
				}
			}
		}
		
		// 초기 고슴도치 위치 설정
		v[startR][startC] = true;
		q.add(new Pos(startR, startC, 0, false));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			//System.out.println(p.r+" "+p.c+ " "+p.t +" "+p.isWater);
			if(p.r==endR && p.c==endC) {
				//System.out.println("도착 : "+p.r+" "+p.c+ " "+p.t);
				time = Math.min(time, p.t);
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=R || nc>=C  || v[nr][nc]) continue;
				
				// 물 ( 돌, 비버의 소굴로 이동 불가 ) 
				if(p.isWater == true) {
					if(map[nr][nc] == 'X' || map[nr][nc] == 'D') continue;
				}
				// 고슴도치 ( 물, 돌 이동 불가 )
				else {
					if(map[nr][nc] == '*' || map[nr][nc] == 'X') continue;
				}
				
				v[nr][nc] = true;
				q.add(new Pos(nr, nc, p.t+1, p.isWater));
			}
		
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);

				if(map[i][j]=='D') { //비버의 굴
					endR = i; 
					endC = j;
				}
				else if(map[i][j]=='S') { //고슴도치 위치
					startR = i; 
					startC = j;
				}
			}
		}
		
		time = Integer.MAX_VALUE;
		
		bfs(startR, startC); 
		if(time==Integer.MAX_VALUE) System.out.println("KAKTUS");
		else System.out.println(time);
		
	}
}
