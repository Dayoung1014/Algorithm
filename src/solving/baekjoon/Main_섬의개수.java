package solving.baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 정사각형 지도에 섬/바다 나와있음
 * 섬 개수 세기
 * 
 * 인접 조건 : 가로, 세로, 대각선
 * 
 * */

public class Main_섬의개수 {
	static int W;
	static int H;
	static int[][] map;
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
        	   W = sc.nextInt();  //지도 가로 길이
        	   H  =sc.nextInt(); //지도 세로 길이
        	   if(W == 0 && H==0) {
        		   break;
        	   }
        	   map = new int[H][W];
        	   for(int h=0; h<H; h++) {
        		   for(int w=0; w<W; w++) {
        			   map[h][w] = sc.nextInt();
        		   }
        	   }
        	   
        	   int cnt = 0;
       			for (int i = 0; i < H; i++) {
       				for (int j = 0; j < W; j++) {
       					if (map[i][j] == 1) {
       						cnt++;
       						bfs(i, j);
       					}
       				}
       			}
       			System.out.println(cnt);
   
        	}
		

	}
	
	static int[] dr = { 1, -1, 0, 0, -1, 1, -1, 1 }; //아래, 위, 오, 왼, 좌상, 좌하, 우상, 우하
	static int[] dc = { 0, 0, 1, -1, -1, -1 ,1, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[H][W];
		v[r][c] = true;

		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = 0;
			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				// 지도안에 있다면
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					Q.add(new Point(nr, nc));
				}
			}
		}
	}

}
