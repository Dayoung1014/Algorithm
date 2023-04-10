package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * R*C인 격자 위에 봄버맨 살고 있음
 * 각 칸은 비어있거나 폭탄 들어있음
 * 
 * 폭탄이 있는 칸은 3초 후 폭발
 * 폭탄이 폭발한 이후에는 폭탄 있던 칸 + 인접 네 칸 파괴되어 빈칸 됨
 * 
 * 1. 가장 처음 봄버맨이 폭탄 설치 
 * 2. 1초 기다림
 * 3. 다음 1초 동안 폭탄이 설치되지 않은 모든 칸에 설치
 * 4. 1초가 지남
 * 5. 3초 시점에 폭탄 폭발
 * 
 * 3~4를 반복
 * 
 * N초가 흐른 후 격자판의 상태 출력
 * 빈 칸은 '.'로, 폭탄은 'O'
 * */

public class Main_16918_봄버맨 {
	static int R, C, N, time;
	static Pos[][] map;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	
	static class Pos{
		int r, c, start;
		boolean isBomb;
		
		public Pos(int r, int c, int start, boolean isBomb) {
			super();
			this.r = r;
			this.c = c;
			this.start = start;
			this.isBomb = isBomb;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //R * C
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //N초뒤
		
		
		
		/*
		 *  * 1. 가장 처음 봄버맨이 폭탄 설치 
			 * 2. 1초 기다림
			 * 3. 다음 1초 동안 폭탄이 설치되지 않은 모든 칸에 설치
			 * 4. 1초가 지남
			 * 5. 3초 시점에 폭탄 폭발
			 * 
			 * 3~4를 반복
		 * */
		
		map = new Pos[R][C];
		time = 0;
		//1. 가장 처음 봄버맨이 폭탄 설치 
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if(line.charAt(j)=='.') map[i][j] = new Pos(i, j, time, false);
				else map[i][j] = new Pos(i, j, time, true);
			}
		}
		
		time = 1; //2. 1초 기다림
		while(time<=N) {
			time++; // 3. 다음 1초 동안 폭탄이 설치되지 않은 모든 칸에 설치
			if(time%2==0) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(!map[i][j].isBomb) map[i][j] = new Pos(i, j, time, true);
					}
				}
			}
			 
			else {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(map[i][j].isBomb && map[i][j].start+3==time) {
							
							for (int d = 0; d < 5; d++) {
								int nr = i+dr[d];
								int nc = i+dc[d];
								if(nr<0 || nc<0 || nr>=R || nc>=C ) continue;
								map[nr][nr] = new Pos(nr, nr, time, false);
							}
						}
					}
				}
			}
		}
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j].isBomb) System.out.print("O");
				else System.out.println(".");
			}
			System.out.println();
		}
		
		
	}
}
