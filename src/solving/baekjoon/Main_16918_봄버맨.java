package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 주의해야 하는 것
 * 연쇄 반응은 없다.
 * -> 반복문을 통해 폭발 시 연쇄 반응 발생
 * -> 순차적 폭발이 아닌 동시 다발적 폭발 진행
 * */

public class Main_16918_봄버맨 {
	static int R, C, N, time;
	static Pos[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Pos{
		int start;
		boolean isBomb;
		
		public Pos(int start, boolean isBomb) {
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
		map = new Pos[R][C];
		
		//1. 가장 처음 봄버맨이 폭탄 설치 
		for (int i = 0; i < R; i++) { 
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if(line.charAt(j)=='.') map[i][j] = new Pos(0, false);
				else map[i][j] = new Pos(0, true);
			}
		}
		
		time=1;
		//2. 1초 기다림
		while(time++<N) {
			// 3. 다음 1초 동안 폭탄이 설치되지 않은 모든 칸에 설치
			if(time%2==0||time==1) { 
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(!map[i][j].isBomb) map[i][j] = new Pos(time, true);
					}
				}
			}
			 
			else { 
				ArrayList<int[]> list = new ArrayList<>();
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(map[i][j].isBomb && map[i][j].start+3==time) {
							map[i][j] = new Pos(0, false);
							for (int d = 0; d < 4; d++) {
								int nr = i +dr[d];
								int nc =j +dc[d];
								if(nr<0 || nc<0 || nr>=R || nc>=C  || map[nr][nc].start+3==time) continue;
								map[nr][nc] = new Pos(0, false);
							}
						}
					}
				}
				
//				for(int[] arr : list) {
//					for (int d = 0; d < 5; d++) {
//						int nr = arr[0]+dr[d];
//						int nc = arr[1]+dc[d];
//						if(nr<0 || nc<0 || nr>=R || nc>=C ) continue;
//						map[nr][nc] = new Pos(0, false);
//					}
//				}
				
			}
		}
		
		//출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j].isBomb) System.out.print("O");
				else System.out.print(".");
			}
			System.out.println();
		}
		System.out.println();
	}
}
