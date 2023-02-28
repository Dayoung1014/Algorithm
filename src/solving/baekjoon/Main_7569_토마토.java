package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 정수 1은 익은 토마토
 * 정수 0 은 익지 않은 토마토
 * 정수 -1은 토마토가 들어있지 않은 칸
 * 
 * 
 * 최소 며칠이 걸리는지를 계산해서 출력
 * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력
 * 토마토가 모두 익지는 못하는 상황이면 -1
 * */

public class Main_7569_토마토 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, N, H;
	static int[][][] map;
	static Queue<Tomato> q = new LinkedList<>();
	//위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	static int[] dm = {0,0, -1, 1, 0, 0}; //가로 이동
	static int[] dn = {0, 0, 0, 0, -1, 1}; //세로 이동
	static int[] dh = {-1, 1, 0, 0, 0, 0}; //높이 이동
	
	static class Tomato {
		int h, n, m;

		public Tomato(int h, int n, int m) {
			super();
			this.h = h;
			this.n = n;
			this.m = m;
		}


	}
	
	// 익지 않은 토마토가 있는지 확인하는 메소드
	private static boolean check0 () {
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(map[h][n][m]==0) return true;
				}
			}
		}
		return false;
	}
	
	private static int bfs() {	
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			for(int d=0; d<6; d++) {
				int nh = t.h + dh[d];
				int nn = t.n + dn[d];
				int nm = t.m + dm[d];
				
				if(nh<0 || nn<0 || nm<0 || nh>=H || nn>=N || nm>=M) continue;
				if(map[nh][nn][nm]==0) {
					q.add(new Tomato(nh, nn, nm));
					map[nh][nn][nm] = map[t.h][t.n][t.m] + 1;
				}
			}
		}
		
		int day = Integer.MIN_VALUE; //모든 토마토가 익은 날
		if(check0()) return -1; //익지 않은 토마토가 있다면 -1 반환
		else { //없다면 모두 익은 최소 날짜 반환
			for(int h=0; h<H; h++) {
				for(int n=0; n<N; n++) {
					for(int m=0; m<M; m++) {
						day = Math.max(day, map[h][n][m]);
					}
				}
			}
			return day-1;
		}
	}
	

	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //상자의 가로칸 수 
		N = Integer.parseInt(st.nextToken()); //상자의 세로칸수
		H = Integer.parseInt(st.nextToken()); //상자의 높이
		
		map = new int[H][N][M];
		
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) {
					map[h][n][m] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
//		for(int h=0; h<H; h++) {
//			for(int n=0; n<N; n++) {
//				System.out.println(Arrays.toString(map[h][n]));
//			}
//		}		
		
		// 안익은 토마토들의 위치를 큐에 넣음
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(map[h][n][m] == 1) {
						q.add(new Tomato(h, n, m));
					}
				}
			}
		}
		
		System.out.println(bfs());
		
		
	}
}
