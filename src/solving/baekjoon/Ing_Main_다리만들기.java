package solving.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 다리를 하나만 놓으려 함
 * 가장 짧은 다리를 놓아 두 대륙을 연결하려고 함
 * 다리의 길이 : 격자 칸 수
 * 
 * 가장 짧은 다리의 길이 출력하기
 * 
 * 세로축의 차이 + 가로축의 사이 -> 다리의 길이
 * 
 * 1과 1사이의 거리중 최소를 구해야 함
 * (단, 다른 섬과 연결해야 함)
 * 
 * 1인곳부터 1인곳까지 연결한 것 중
 * 
 * */

public class Ing_Main_다리만들기 {
	static int N;
	static int[][] map;
	static int[][] newMap;
	static boolean[][] visited;
	static int island=1; // 섬 번호로 넣기
	static int minLen = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //지도의 크기
		map = new int[N][N];
		
		
		for(int i=0; i<N; i++) { // 지도 그리기
			for(int j=0; j<N; j++) {
				int input = sc.nextInt();
				map[i][j] = input;
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) { // 섬 번호 설정하기
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 & !visited[i][j]) { //섬인데 방문하지 않았다면
					setNumber(i, j);
					island++; 
				}
			}
		}
		
		minLen = 1;
		for(int is=2; is <=4; is++) {
			visited = new boolean[N][N]; //초기화
			for(int i=0; i<N; i++) { // 다리 건설 (섬~섬) 연결했을 때 길이가 짧은 것 구하기
				for(int j=0; j<N; j++) {
					if(map[i][j]==is & !visited[i][j]) { //섬인데 방문하지 않았다면
						bridge(i, j, is);
						
					}
				}
			}
		}
		
		
		// 최소값 구한거에서 2 빼야 함
		
		
		
		for(int i=0; i<N; i++) { 
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		
		System.out.println(minLen);
	}
	
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	private static void setNumber(int r, int c) {
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[N][N];
		v[r][c] = true;
		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = island;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];   
				int nc = p.c + dc[d];
				// 지도안에 있다면
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					Q.add(new Point(nr, nc));
				}
			}
		}
		
	}
	
	static class Island {
		int r, c, num;

		public Island(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	
	private static void bridge(int r, int c, int num) {
		Queue<Island> Q = new LinkedList();
		boolean[][] v = new boolean[N][N];
		v[r][c] = true;

		Q.offer(new Island(r, c, num));

		while (!Q.isEmpty()) {
			Island i = Q.poll();
			//map[i.r][i.c] = island;
			for (int d = 0; d < 4; d++) {
				int nr = i.r + dr[d];   
				int nc = i.c + dc[d];
				// 지도안에 있다면
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc]==0) {
					//v[nr][nc] = true;
					continue;
				}
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] != num) {
					v[nr][nc] = true;
					System.out.println(Math.abs(nr-r) + " " + Math.abs(nc-c));
					minLen = Math.min(minLen, Math.abs(nr-r) + Math.abs(nc-r));
					Q.add(new Island(nr, nc, map[nr][nc]));
				}
			}
		}
	}

}
