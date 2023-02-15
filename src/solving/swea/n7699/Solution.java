package solving.swea.n7699;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 섬 : 1행 1열 ~ R행 C열 (R*C)
 * 
 * 시작 지점 : 1행 1열
 * 
 * 명물 
 * - 각 칸에 알파벳으로 적힘 (각은 알파벳은 같은 명물)
 * 
 * 수지의 목표
 * - 1행 1열에서 여행 시작
 * - 같은 알파벳 명물을 두 번 이상 보지 않도록
 * -> 명물의 최대 개수 구하기
 * 
 * */

import java.util.Scanner;
import java.util.Stack;


class Solution {
	static int R;
	static int C;
	static Character[][] map;
	static ArrayList<Character> alpha;
	static int count;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			R = sc.nextInt();
			C = sc.nextInt();
			map = new Character[R][C];
			
			for(int r=0; r<R; r++) { //지도 입력 받기
				String str = sc.next();
				for(int c=0; c<C; c++) {
					map[r][c] = str.charAt(c);
				}
			}
			
			//방문한 명물 저장 contain으로 확인할 예정
			//방문한 개수도 alpha의 size로 확인
			
			dfs();
			System.out.println("#"+test_case+" "+alpha.size());
			System.out.println(alpha.toString());
			
		}
	}
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	private static void bfs() {
		Queue<Point> Q = new LinkedList();
		// 방문배열
		alpha.add(map[0][0]);
		Q.offer(new Point(0,0));
		
		while(!Q.isEmpty()) {
				Point p = Q.poll();
			
				for (int d = 0; d < 4; d++) {
					int nr = p.r+dr[d];
					int nc = p.c+dc[d];
					if(nr>=0 && nr<R && nc>=0 && nc<C && !alpha.contains(map[nr][nc])) {
						alpha.add(map[nr][nc]);
						Q.add(new Point(nr,nc));
					}
				}
			
		}
	}
	
	private static void dfs() {
		Stack<Point> stack = new Stack<>();
		// 방문배열
		alpha = new ArrayList<>(); 
		alpha.add(map[0][0]);
		stack.push(new Point(0,0));
		
		while(!stack.isEmpty()) {
				Point p = stack.pop();
			
				for(int r=0; r<R; r++) { 
					for(int c=0; c<C; c++) {
						for (int d = 0; d < 4; d++) {
							int nr = p.r+dr[d];
							int nc = p.c+dc[d];
							if(nr>=0 && nr<R && nc>=0 && nc<C && !alpha.contains(map[nr][nc])) {
								alpha.add(map[nr][nc]);
								stack.push(new Point(nr, nc));
							}
						}
					}
				}	
		}
	}
	
}