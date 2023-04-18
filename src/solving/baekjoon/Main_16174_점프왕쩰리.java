package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 가로 세로의 칸수가 같은 정사각형 구역
 * 나가면 패배
 * 왼위에서 출발
 * 이동은 오른쪽과 아래
 * 오아래 도착점 
 * 한 번에 이동할 수 있는 칸은 밟고 있는 칸에 적힌 수 만큼
 * */

public class Main_16174_점프왕쩰리 {
	static int N;
	static int[][] map;
	static int[] dr = {1, 0}; //아래 오른쪽
	static int[] dc = {0, 1}; 
	
	static class Point {
		int r,c ;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static boolean bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		
		v[0][0] = true;
		q.add(new Point(0,0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.r==N-1 && p.c==N-1) return true;
			
			for (int i = 0; i < 2; i++) {
				int nr = p.r + dr[i]*map[p.r][p.c];
				int nc = p.c + dc[i]*map[p.r][p.c];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc]) continue;
				v[nr][nc] = true;
				q.add(new Point(nr, nc));
			}
		}
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(bfs()) System.out.println("HaruHaru");
		else System.out.println("Hing");
		
	}
}
