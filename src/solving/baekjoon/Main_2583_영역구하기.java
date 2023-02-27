package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 눈금이 간격 1인 M, N 크기의 모눈종이
 * 직사각형 제외하고 몇 개의 영역으로 나눠지는지 
 * 각 영역의 크기가 얼마인지
 *
 * */

public class Main_2583_영역구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int M, N, cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Integer> area = new ArrayList<>();
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		
	}
	
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[M][N];
		
		q.offer(new Point(r, c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.r][p.c] = -1;
			for(int d=0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr<0 || nc<0 || nr >=M || nc >= N) continue;
				if(!v[nr][nc] && map[nr][nc] ==0) {
					v[nr][nc] = true;
					//bfs(nr, nc);
					q.offer(new Point (nr, nc));
					
					area.add(area.remove(area.size()-1) + 1);
				}
			}
		}
		
	}
 	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //map 세로 
		N = Integer.parseInt(st.nextToken()); //map 가로 
		int K = Integer.parseInt(st.nextToken()); //직사각형 개수
		
		map = new int[M][N];
		
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			// 직사각형 왼쪽 아래 꼭지점, 오른쪽 위 꼭지점
			int left_x = Integer.parseInt(st.nextToken());
			int left_y= Integer.parseInt(st.nextToken());
			int right_x = Integer.parseInt(st.nextToken());
			int right_y = Integer.parseInt(st.nextToken());
			
			for(int i=left_y; i<right_y; i++) {
				for(int j=left_x; j<right_x; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		cnt = 0; 
		
//		for(int i=M-1; i>=0; i--) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) {
					cnt++;
					area.add(1);
					bfs(i, j);
				}
			}
		}
		

		System.out.println(cnt);
		Collections.sort(area);
		for(int a : area) {
			System.out.print(a +" ");
		}
	}

}
